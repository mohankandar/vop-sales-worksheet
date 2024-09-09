package com.wynd.vop.sales.worksheet.model;

import com.wynd.vop.framework.rest.provider.ProviderResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents the response object for the Sales Preset Package Inventory entity.
 * This class is used to transfer Sales Preset Package Inventory data to the client or other parts of the application.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PresetPackageResponse extends ProviderResponse implements Serializable {

  private BigDecimal salesPresetPackageInventoryId;
  private BigDecimal presetPackageNumberOfCriteria;
  private LocalDateTime presetPackageCreateOrUpdateDate;
  private String presetPackageUpdateFlag;
  private String serviceEntity;
  private BigDecimal siteId;
  private String inventoryType;
  private BigDecimal totalPoints;
  private BigDecimal developerPrice;
  private BigDecimal defaultMinimumDownPercentage;
  private BigDecimal customerMinimumDownPercentage;
  private BigDecimal defaultInterestRate;
  private BigDecimal maxDiscountType;
  private BigDecimal customerMaxDiscount;
  private BigDecimal maintenanceFee;
  private String inventoryId;
  private BigDecimal loanTerm;
  private BigDecimal customerLoanTerm;
  private BigDecimal processingFee;
  private String bonusPointType;
  private boolean active;
  private LocalDateTime createDate;
  private String createUserId;
  private LocalDateTime modifyDate;
  private String modifyUserId;

}
