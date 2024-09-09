package com.wynd.vop.sales.worksheet.model;

import com.wynd.vop.framework.service.DomainResponse;

/**
 * This domain model represents a response from processing
 * a request for SampleInfoDomain by participant ID.
 * <p>This response is returned by the domain service implementation to the provider.</p>
 */
public class SampleDomainResponse extends DomainResponse {

  /**
   * Id for serialization.
   */
  private static final long serialVersionUID = 8470614006372046829L;

  /**
   * A SampleInfoDomain instance.
   */
  private SampleInfoDomain sampleInfoDomain;

  /**
   * Gets the sample info.
   *
   * @return A SampleInfoDomain instance
   */
  public final SampleInfoDomain getSampleInfo() {
    return sampleInfoDomain;
  }

  /**
   * Sets the sample info.
   *
   * @param sampleInfoDomain A SampleInfoDomain instance
   */
  public final void setSampleInfo(final SampleInfoDomain sampleInfoDomain) {
    this.sampleInfoDomain = sampleInfoDomain;
  }
}
