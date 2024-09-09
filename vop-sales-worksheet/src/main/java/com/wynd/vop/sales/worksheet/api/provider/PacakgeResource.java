package com.wynd.vop.sales.worksheet.api.provider;

import com.wynd.vop.framework.log.VopLogger;
import com.wynd.vop.framework.log.VopLoggerFactory;
import com.wynd.vop.framework.swagger.SwaggerResponseMessages;
import com.wynd.vop.sales.worksheet.api.PackageApi;
import com.wynd.vop.sales.worksheet.model.PresetPackageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class PacakgeResource implements PackageApi, SwaggerResponseMessages {


  // Logger instance for logging information and debugging purposes
  private static final VopLogger LOGGER = VopLoggerFactory.getLogger(WorksheetResource.class);

  // Message used for logging when returning a response to the consumer
  private static final String LOG_MSG_RETURNING = "Returning providerResponse to consumer";

  // Root path for this REST resource
  public static final String URL_PREFIX = "/api/v1/worksheet";

  // Service adapter for handling business logic and interacting with the service layer
  @Autowired
  ServiceAdapter serviceAdapter;

  // Properties containing build information for the application
  @Autowired
  BuildProperties buildProperties;

  /**
   * Method annotated with @PostConstruct to log build information after the
   * bean is initialized. This method is automatically called after the
   * constructor and dependency injection are complete.
   */
  @PostConstruct
  public void postConstruct() {
    // Log build properties such as name, version, artifact, and group
    LOGGER.info(buildProperties.getName());
    LOGGER.info(buildProperties.getVersion());
    LOGGER.info(buildProperties.getArtifact());
    LOGGER.info(buildProperties.getGroup());
  }

  /**
   * Initializes the data binder to specify which fields should be allowed for
   * data binding. This method is called before each request handling method.
   *
   * @param binder WebDataBinder instance used to set allowed fields for data binding
   */
  @InitBinder
  public void initBinder(final WebDataBinder binder) {
    // Allow only specific fields for data binding in incoming requests
    binder.setAllowedFields("sampleInfo", "name", "participantId");
  }

  @Override
  public ResponseEntity<List<PresetPackageResponse>> presetPackagesBySiteIdAndEntityId(String siteId, String entityId) {
    // Log that the sampleByPid method has been invoked
    LOGGER.debug("presetPackagesBySiteIdAndEntityId() method invoked");
    // Call the service layer to process the request and retrieve the sample response
    List<PresetPackageResponse> presetPackageResponse = serviceAdapter.presetPackagesBySiteIdAndEntityId(siteId, entityId);

    // Log the message indicating that the response is being returned to the consumer
    LOGGER.debug(LOG_MSG_RETURNING);

    // Return the sample response wrapped in a ResponseEntity with HTTP status 200 OK
    return new ResponseEntity<>(presetPackageResponse, HttpStatus.OK);
  }
}
