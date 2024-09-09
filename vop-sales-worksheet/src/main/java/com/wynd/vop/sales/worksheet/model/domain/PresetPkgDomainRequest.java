package com.wynd.vop.sales.worksheet.model.domain;

import com.wynd.vop.framework.service.DomainRequest;
import com.wynd.vop.sales.worksheet.model.PresetPkgRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a request for Sales Preset Package Inventory.
 * <p>
 * This class extends {@link DomainRequest} and is used to encapsulate the parameters
 * required to make a request for Sales Preset Package Inventory, including site number,
 * site ID, and entity ID.
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
public class PresetPkgDomainRequest extends DomainRequest {
  /**
   * The name of the model, derived from the class name.
   */
  public static final String MODEL_NAME = PresetPkgDomainRequest.class.getSimpleName();

  /**
   * The site number associated with the Sales Preset Package Inventory request.
   */
  private String siteNumber;

  /**
   * The site ID associated with the Sales Preset Package Inventory request.
   */
  private String siteId;

  /**
   * The entity ID associated with the Sales Preset Package Inventory request.
   */
  private String serviceEntity;

}
