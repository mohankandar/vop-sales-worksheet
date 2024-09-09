package com.wynd.vop.sales.worksheet.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents the Sales Preset Package Inventory entity.
 * <p>
 * This entity maps to the {@code SALES_PRESET_PKG_INVENTORY} table in the {@code WSA} schema of the database.
 * It contains information about the preset package inventory, including various attributes such as criteria
 * count, creation/update date, service entity, and other related fields.
 * </p>
 */
@Entity
@Table(name = "SALES_PRESET_PKG_INVENTORY", schema = "WSA")
@Getter
@Setter
public class SalesPresetPkgInventory {

  /**
   * Unique identifier for the Sales Preset Package Inventory.
   */
  @Id
  @Column(name = "SALES_PRESET_PKG_INV_ID", nullable = false)
  private BigDecimal salesPresetPkgInvId;

  /**
   * Number of criteria for the preset package.
   */
  @Column(name = "PRESET_PKG_NUM_OF_CRITERIA")
  private BigDecimal presetPkgNumOfCriteria;

  /**
   * Date when the preset package was created or last updated.
   */
  @Column(name = "PRESET_PKG_CREATE_OR_UPDATE_DT", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date presetPkgCreateOrUpdateDt;

  /**
   * Flag indicating the update status of the preset package.
   */
  @Column(name = "PRESET_PKG_UPDATE_FLAG")
  private String presetPkgUpdateFlag;

  /**
   * Service entity associated with the preset package.
   */
  @Column(name = "SERVICE_ENTITY", nullable = false, length = 50)
  private String serviceEntity;

  /**
   * Site ID where the preset package is applicable.
   */
  @Column(name = "SITE_ID", nullable = false)
  private BigDecimal siteId;

  /**
   * Type of the inventory.
   */
  @Column(name = "INV_TYPE", length = 50)
  private String invType;

  /**
   * Total points associated with the preset package.
   */
  @Column(name = "TOT_PTS", nullable = false)
  private BigDecimal totPts;

  /**
   * Price set by the developer for the preset package.
   */
  @Column(name = "DEVELOPER_PRICE", nullable = false)
  private BigDecimal developerPrice;

  /**
   * Default minimum down payment percentage.
   */
  @Column(name = "DFT_MIN_DOWN_PCT", precision = 38, scale = 4)
  private BigDecimal dftMinDownPct;

  /**
   * Customer's minimum down payment percentage.
   */
  @Column(name = "CUST_MIN_DOWN_PCT", precision = 38, scale = 4)
  private BigDecimal custMinDownPct;

  /**
   * Default interest rate for the preset package.
   */
  @Column(name = "DFT_INT_RATE", precision = 38, scale = 2)
  private BigDecimal dftIntRate;

  /**
   * Maximum discount type applicable to the preset package.
   */
  @Column(name = "MAX_DISOCUNT_TYPE")
  private BigDecimal maxDisocuntType;

  /**
   * Maximum discount amount applicable to the preset package for the customer.
   */
  @Column(name = "CUST_MAX_DISOCUNT")
  private BigDecimal custMaxDisocunt;

  /**
   * Maintenance fee associated with the preset package.
   */
  @Column(name = "MAINTENANCE_FEE", precision = 38, scale = 2)
  private BigDecimal maintenanceFee;

  /**
   * Inventory ID for the preset package.
   */
  @Column(name = "INV_ID", length = 50)
  private String invId;

  /**
   * Loan term associated with the preset package.
   */
  @Column(name = "LOAN_TERM")
  private BigDecimal loanTerm;

  /**
   * Customer's loan term.
   */
  @Column(name = "CUST_LOAN_TERM")
  private BigDecimal custLoanTerm;

  /**
   * Processing fee for the preset package.
   */
  @Column(name = "PROC_FEE", precision = 38, scale = 2)
  private BigDecimal procFee;

  /**
   * Type of bonus points associated with the preset package.
   */
  @Column(name = "BONUS_POINT_TYPE", length = 50)
  private String bonusPointType;

  /**
   * Indicates whether the preset package is active.
   */
  @Column(name = "IS_ACTIVE", length = 50)
  private String isActive;

  /**
   * Date when the preset package was created.
   */
  @Column(name = "CREATE_DATE")
  @Temporal(TemporalType.DATE)
  private Date createDate;

  /**
   * User ID of the person who created the preset package.
   */
  @Column(name = "CREATE_USER_ID", length = 50)
  private String createUserId;

  /**
   * Date when the preset package was last modified.
   */
  @Column(name = "MOD_DATE")
  @Temporal(TemporalType.DATE)
  private Date modDate;

  /**
   * User ID of the person who last modified the preset package.
   */
  @Column(name = "MOD_USER_ID", length = 50)
  private String modUserId;

  // Getters and setters
  // Add getters and setters for all fields
}
