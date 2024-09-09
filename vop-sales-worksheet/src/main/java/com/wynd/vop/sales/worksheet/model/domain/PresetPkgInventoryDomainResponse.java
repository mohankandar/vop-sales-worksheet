package com.wynd.vop.sales.worksheet.model.domain;

import com.wynd.vop.framework.service.DomainResponse;
import com.wynd.vop.sales.worksheet.model.PresetPackageResponse;

public class PresetPkgInventoryDomainResponse extends DomainResponse {

  /**
   * Id for serialization.
   */
  private static final long serialVersionUID = 8470614006372046829L;

  /**
   * A PresetPkgResponse instance.
   */
  private PresetPackageResponse presetPackageResponse;

  /**
   * Gets the PresetPkgResponse info.
   *
   * @return A PresetPkgResponse instance
   */
  public final PresetPackageResponse getPresetPkgResponse() {
    return presetPackageResponse;
  }

  /**
   * Sets the PresetPkgResponse info.
   *
   * @param presetPackageResponse A PresetPkgResponse instance
   */
  public final void setPresetPkgResponse(final PresetPackageResponse presetPackageResponse) {
    this.presetPackageResponse = presetPackageResponse;
  }
}
