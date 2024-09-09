package com.wynd.vop.sales.worksheet.model;

import com.wynd.vop.framework.rest.provider.ProviderRequest;
import com.wynd.vop.framework.service.DomainRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
@NoArgsConstructor
public class PresetPkgRequest extends ProviderRequest implements Serializable {

  /**
   * The name of the model, derived from the class name.
   */
  public static final String MODEL_NAME = PresetPkgRequest.class.getSimpleName();

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