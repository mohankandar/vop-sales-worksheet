package com.wynd.vop.sales.worksheet.impl;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wynd.vop.sales.worksheet.data.entity.SalesPresetPkgInventory;
import com.wynd.vop.sales.worksheet.data.repository.wsa.InventoryPresetPkgRepository;
import com.wynd.vop.sales.worksheet.model.*;
import com.wynd.vop.sales.worksheet.service.WorksheetService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wynd.vop.framework.cache.CacheUtil;
import com.wynd.vop.framework.log.VopLogger;
import com.wynd.vop.framework.log.VopLoggerFactory;
import com.wynd.vop.framework.messages.MessageKeys;
import com.wynd.vop.framework.messages.MessageSeverity;
import com.wynd.vop.sales.worksheet.messages.WorksheetMessageKeys;
import com.wynd.vop.sales.worksheet.utils.CacheConstants;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class for the Worksheet Service.
 * The class demonstrates the implementation of resilience4j circuit breaker pattern for read
 * operations. When there is a failure the fallback method is invoked and the
 * response is returned from the cache.
 */
@Service(value = WorksheetServiceImpl.BEAN_NAME)
@Component
@Qualifier("WORKSHEET_SERVICE_IMPL")
@RefreshScope
public class WorksheetServiceImpl implements WorksheetService {
  private static final VopLogger LOGGER = VopLoggerFactory.getLogger(WorksheetServiceImpl.class);

  /**
   * Bean name constant.
   */
  public static final String BEAN_NAME = "worksheetServiceImpl";

  /**
   * The cache manager (redis implementation).
   */
  @Autowired
  private CacheManager cacheManager;

  @Autowired
  InventoryPresetPkgRepository inventoryPresetPkgRepository;

  @Autowired
  ObjectMapper objectMapper;

  /**
   * Viability checks before the application is put into service.
   */
  @PostConstruct
  void postConstruct() {
  }

  /**
   * Implementation of the service (domain) layer API.
   * <p>If graceful degradation is possible, add
   * {@code fallbackMethod = "sampleFindByParticipantIdFallBack"}
   * to the {@code @CircuitBreaker}.</p>
   * <p>{@inheritDoc}</p>
   */
  @Override
  @CachePut(value = CacheConstants.CACHENAME_WORKSHEET_SERVICE,
          key = "#root.methodName + T(com.wynd.vop.framework.cache.CacheUtil).createKey(#sampleDomainRequest.participantId)",
          unless = "T(com.wynd.vop.framework.cache.CacheUtil).checkResultConditions(#result)")
  @CircuitBreaker(name = "sampleFindByParticipantId", fallbackMethod = "sampleFindByParticipantIdFallBack")
  @Bulkhead(name = "sampleFindByParticipantId")
  @RateLimiter(name = "sampleFindByParticipantId")
  @Retry(name = "sampleFindByParticipantId")
  public SampleDomainResponse sampleFindByParticipantId(final SampleDomainRequest sampleDomainRequest) {

    String cacheKey = "sampleFindByParticipantId" + CacheUtil.createKey(sampleDomainRequest.getParticipantId());

    // try from cache
    SampleDomainResponse response = new SampleDomainResponse();
    try {
      Cache cache = null;
      if ((cacheManager != null) && ((cache = cacheManager.getCache(CacheConstants.CACHENAME_WORKSHEET_SERVICE)) != null)
              && (cache.get(cacheKey) != null)) {
        LOGGER.debug("sampleFindByParticipantId returning cached data");
        response = cache.get(cacheKey, SampleDomainResponse.class);
        return response;
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
    }

    LOGGER.debug("sampleFindByParticipantId no cached data found");

    // send hard-coded data ... normally would get from db or partner
    SampleInfoDomain sampleInfoDomain = new SampleInfoDomain();
    sampleInfoDomain.setName("JANE DOE");
    sampleInfoDomain.setParticipantId(sampleDomainRequest.getParticipantId());
    response.setSampleInfo(sampleInfoDomain);
    response.addMessage(MessageSeverity.INFO, HttpStatus.OK, WorksheetMessageKeys.VOP_SAMPLE_SERVICE_IMPL_RESPONDED_WITH_MOCK_DATA,
            "");
    return response;
  }


  @Override
  @CachePut(value = CacheConstants.CACHENAME_WORKSHEET_SERVICE,
          key = "#root.methodName + T(com.wynd.vop.framework.cache.CacheUtil).createKey(#salesPresetPkgInventoryDomainRequest.siteId)",
          unless = "T(com.wynd.vop.framework.cache.CacheUtil).checkResultConditions(#result)")
  @CircuitBreaker(name = "presetPackagesBySiteIdAndEntityId", fallbackMethod = "presetPackagesBySiteIdAndEntityIdFallBack")
  @Bulkhead(name = "presetPackagesBySiteIdAndEntityId")
  @RateLimiter(name = "presetPackagesBySiteIdAndEntityId")
  @Retry(name = "presetPackagesBySiteIdAndEntityId")
  public List<PresetPackageResponse> presetPackagesBySiteIdAndEntityId(PresetPkgRequest presetPkgRequest) {
    String cacheKey = "presetPackagesBySiteIdAndEntityId" + CacheUtil.createKey(presetPkgRequest.getSiteId());

    // try from cache
    List<PresetPackageResponse> response;
    try {
      Cache cache = null;
      if ((cacheManager != null) && ((cache = cacheManager.getCache(CacheConstants.CACHENAME_WORKSHEET_SERVICE)) != null)
              && (cache.get(cacheKey) != null)) {
        LOGGER.debug("presetPackagesBySiteIdAndEntityId returning cached data");
        String cachedValue = cache.get(cacheKey, String.class);
        if (cachedValue != null) {
          response = objectMapper.readValue(cachedValue, new TypeReference<List<PresetPackageResponse>>() {
          });
          return response;
        }
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
    }

    LOGGER.debug("presetPackagesBySiteIdAndEntityId no cached data found");

    List<SalesPresetPkgInventory> salesPresetPkgInventory =
            inventoryPresetPkgRepository.findBySiteIdAndServiceEntity(
                    new BigDecimal(presetPkgRequest.getSiteId()),
                    presetPkgRequest.getServiceEntity()
            );
    //return SalesPresetPkgInventoryMapper.toDtoList(salesPresetPkgInventory);
    return null;
  }

  /**
   * Support graceful degradation by adding a fallback method that @CircuitBreaker will call to obtain a
   * default value or values in case the main command fails for {@link #sampleFindByParticipantId(SampleDomainRequest)}.
   *
   * @param sampleDomainRequest The request from the Java Service.
   * @param throwable           the throwable
   * @return A JAXB element for the WS request
   * @CircuitBreaker doesn't REQUIRE you to set this method. However, if it is possible to degrade gracefully
   * - perhaps by returning static data, or performing some other process - the degraded process should
   * be performed in the fallback method. In order to enable a fallback such as this, on the main method,
   * add to its {@code @CircuitBreaker} the {@code fallbackMethod} attribute. So for
   * {@link #sampleFindByParticipantId(SampleDomainRequest)}
   * you would add the attribute to its {@code @CircuitBreaker}:<br/>
   *
   * <pre>
   * fallbackMethod = "sampleFindByParticipantIdFallBack"
   * </pre>
   * <p>This fallback method logs the activation and returns a default {@link SampleDomainResponse} with a warning message.</p>
   */
  public SampleDomainResponse sampleFindByParticipantIdFallBack(final SampleDomainRequest sampleDomainRequest,
                                                                final Throwable throwable) {
    LOGGER.info("sampleFindByParticipantIdFallBack has been activated");

    /*
     * Fallback Method for Demonstration Purpose. In this use case, there is no static / mock data
     * that can be sent back to the consumers. Hence the method isn't configured as fallback.
     *
     * If needed to be configured, add annotation to the implementation method "findWorksheetByParticipantId" as below
     *
     * @HystrixCommand(fallbackMethod = "findWorksheetByParticipantIdFallBack")
     */
    final SampleDomainResponse response = new SampleDomainResponse();
    response.setDoNotCacheResponse(true);

    if (throwable != null) {
      LOGGER.debug(ReflectionToStringBuilder.toString(throwable, null, true, true, Throwable.class));
      response.addMessage(MessageSeverity.WARN, HttpStatus.OK, MessageKeys.VOP_GLOBAL_GENERAL_EXCEPTION,
              throwable.getClass().getSimpleName(), throwable.getLocalizedMessage());
    } else {
      LOGGER.error(
              "sampleFindByParticipantIdFallBack No Throwable Exception. Just Raise Runtime Exception {}",
              sampleDomainRequest);
      response.addMessage(MessageSeverity.WARN, HttpStatus.OK, MessageKeys.WARN_KEY,
              "There was a problem processing your request.");
    }
    return response;
  }

  /**
   * Fallback method for the {@link #presetPackagesBySiteIdAndEntityId(PresetPkgRequest)} method when an exception
   * occurs during execution. This method is triggered when the main method fails due to an exception or any circuit-breaking
   * conditions as defined in the {@link CircuitBreaker} or {@link Retry} annotations.
   * <p>
   * The fallback method logs the exception (if available) or raises an error if no throwable is provided.
   * The method returns an empty list of {@link PresetPackageResponse} to handle the failure gracefully.
   * </p>
   *
   * @param presetPkgRequest the original {@link PresetPkgRequest} object containing the request details such as siteId and entityId.
   * @param throwable        the {@link Throwable} that caused the failure in the original method. It may contain the details of the error.
   * @return an empty list of {@link PresetPackageResponse} to ensure a non-failing response.
   */
  public List<PresetPackageResponse> presetPackagesBySiteIdAndEntityIdFallBack(final PresetPkgRequest presetPkgRequest,
                                                                               final Throwable throwable) {
    LOGGER.info("presetPackagesBySiteIdAndEntityIdFallBack has been activated");

    final List<PresetPackageResponse> response = new ArrayList<>();

    if (throwable != null) {
      LOGGER.error(ReflectionToStringBuilder.toString(throwable, null, true, true, Throwable.class));
    } else {
      LOGGER.error(
              "presetPackagesBySiteIdAndEntityIdFallBack No Throwable Exception. Just Raise Runtime Exception {}",
              presetPkgRequest);
    }
    return response;
  }

}
