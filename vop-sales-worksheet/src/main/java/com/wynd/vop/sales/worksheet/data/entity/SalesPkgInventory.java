package com.wynd.vop.sales.worksheet.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Represents the Sales Package Inventory entity.
 */
@Entity
@Table(name = "SALES_PKG_INVENTORY", schema = "WSA")
public class SalesPkgInventory {

  @Id
  @Column(name = "SALES_PKG_INV_ID", length = 15)
  private String salesPkgInvId;

  @Column(name = "SERVICE_ENTITY", length = 3, nullable = false)
  private String serviceEntity;

  @Column(name = "INV_TYPE", length = 50)
  private String invType;

  @Column(name = "TOT_PTS", nullable = false)
  private Long totPts;

  @Column(name = "DFT_CRDT_BND", length = 15)
  private String dftCrdtBnd;

  @Column(name = "DFT_MIN_DOWN_PCT", precision = 13, scale = 2)
  private Double dftMinDownPct;

  @Column(name = "DFT_INT_RATE", precision = 13, scale = 2)
  private Double dftIntRate;

  @Column(name = "IS_VISIBLE", length = 3)
  private String isVisible;

  @Column(name = "EFF_START_DATE", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date effStartDate;

  @Column(name = "EFF_END_DATE")
  @Temporal(TemporalType.DATE)
  private Date effEndDate;

  @Column(name = "CREATE_DATE")
  @Temporal(TemporalType.DATE)
  private Date createDate;

  @Column(name = "CREATE_NAME", length = 50)
  private String createName;

  @Column(name = "MOD_DATE")
  @Temporal(TemporalType.DATE)
  private Date modDate;

  @Column(name = "MOD_NAME", length = 50)
  private String modName;

  @Column(name = "INV_ID", length = 15)
  private String invId;

  @Column(name = "IS_ACTIVE")
  private Integer isActive;

  @Column(name = "LOAN_TERM")
  private Long loanTerm;

  @Column(name = "CREATED_USER_NAME", length = 250)
  private String createdUserName;

  @Column(name = "MODIFIED_USER_NAME", length = 250)
  private String modifiedUserName;

  /**
   * Gets the sales package inventory ID.
   *
   * @return the sales package inventory ID
   */
  public String getSalesPkgInvId() {
    return salesPkgInvId;
  }

  /**
   * Sets the sales package inventory ID.
   *
   * @param salesPkgInvId the new sales package inventory ID
   */
  public void setSalesPkgInvId(String salesPkgInvId) {
    this.salesPkgInvId = salesPkgInvId;
  }

  /**
   * Gets the service entity.
   *
   * @return the service entity
   */
  public String getServiceEntity() {
    return serviceEntity;
  }

  /**
   * Sets the service entity.
   *
   * @param serviceEntity the new service entity
   */
  public void setServiceEntity(String serviceEntity) {
    this.serviceEntity = serviceEntity;
  }

  /**
   * Gets the inventory type.
   *
   * @return the inventory type
   */
  public String getInvType() {
    return invType;
  }

  /**
   * Sets the inventory type.
   *
   * @param invType the new inventory type
   */
  public void setInvType(String invType) {
    this.invType = invType;
  }

  /**
   * Gets the total points.
   *
   * @return the total points
   */
  public Long getTotPts() {
    return totPts;
  }

  /**
   * Sets the total points.
   *
   * @param totPts the new total points
   */
  public void setTotPts(Long totPts) {
    this.totPts = totPts;
  }

  /**
   * Gets the default credit band.
   *
   * @return the default credit band
   */
  public String getDftCrdtBnd() {
    return dftCrdtBnd;
  }

  /**
   * Sets the default credit band.
   *
   * @param dftCrdtBnd the new default credit band
   */
  public void setDftCrdtBnd(String dftCrdtBnd) {
    this.dftCrdtBnd = dftCrdtBnd;
  }

  /**
   * Gets the default minimum down payment percentage.
   *
   * @return the default minimum down payment percentage
   */
  public Double getDftMinDownPct() {
    return dftMinDownPct;
  }

  /**
   * Sets the default minimum down payment percentage.
   *
   * @param dftMinDownPct the new default minimum down payment percentage
   */
  public void setDftMinDownPct(Double dftMinDownPct) {
    this.dftMinDownPct = dftMinDownPct;
  }

  /**
   * Gets the default interest rate.
   *
   * @return the default interest rate
   */
  public Double getDftIntRate() {
    return dftIntRate;
  }

  /**
   * Sets the default interest rate.
   *
   * @param dftIntRate the new default interest rate
   */
  public void setDftIntRate(Double dftIntRate) {
    this.dftIntRate = dftIntRate;
  }

  /**
   * Gets the visibility status.
   *
   * @return the visibility status
   */
  public String getIsVisible() {
    return isVisible;
  }

  /**
   * Sets the visibility status.
   *
   * @param isVisible the new visibility status
   */
  public void setIsVisible(String isVisible) {
    this.isVisible = isVisible;
  }

  /**
   * Gets the effective start date.
   *
   * @return the effective start date
   */
  public Date getEffStartDate() {
    return effStartDate;
  }

  /**
   * Sets the effective start date.
   *
   * @param effStartDate the new effective start date
   */
  public void setEffStartDate(Date effStartDate) {
    this.effStartDate = effStartDate;
  }

  /**
   * Gets the effective end date.
   *
   * @return the effective end date
   */
  public Date getEffEndDate() {
    return effEndDate;
  }

  /**
   * Sets the effective end date.
   *
   * @param effEndDate the new effective end date
   */
  public void setEffEndDate(Date effEndDate) {
    this.effEndDate = effEndDate;
  }

  /**
   * Gets the creation date.
   *
   * @return the creation date
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * Sets the creation date.
   *
   * @param createDate the new creation date
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * Gets the name of the person who created the record.
   *
   * @return the creator's name
   */
  public String getCreateName() {
    return createName;
  }

  /**
   * Sets the name of the person who created the record.
   *
   * @param createName the new creator's name
   */
  public void setCreateName(String createName) {
    this.createName = createName;
  }

  /**
   * Gets the last modification date.
   *
   * @return the last modification date
   */
  public Date getModDate() {
    return modDate;
  }

  /**
   * Sets the last modification date.
   *
   * @param modDate the new modification date
   */
  public void setModDate(Date modDate) {
    this.modDate = modDate;
  }

  /**
   * Gets the name of the person who last modified the record.
   *
   * @return the modifier's name
   */
  public String getModName() {
    return modName;
  }

  /**
   * Sets the name of the person who last modified the record.
   *
   * @param modName the new modifier's name
   */
  public void setModName(String modName) {
    this.modName = modName;
  }

  /**
   * Gets the inventory ID.
   *
   * @return the inventory ID
   */
  public String getInvId() {
    return invId;
  }

  /**
   * Sets the inventory ID.
   *
   * @param invId the new inventory ID
   */
  public void setInvId(String invId) {
    this.invId = invId;
  }

  /**
   * Gets the active status.
   *
   * @return the active status
   */
  public Integer getIsActive() {
    return isActive;
  }

  /**
   * Sets the active status.
   *
   * @param isActive the new active status
   */
  public void setIsActive(Integer isActive) {
    this.isActive = isActive;
  }

  /**
   * Gets the loan term.
   *
   * @return the loan term
   */
  public Long getLoanTerm() {
    return loanTerm;
  }

  /**
   * Sets the loan term.
   *
   * @param loanTerm the new loan term
   */
  public void setLoanTerm(Long loanTerm) {
    this.loanTerm = loanTerm;
  }

  /**
   * Gets the name of the user who created the record.
   *
   * @return the creator's user name
   */
  public String getCreatedUserName() {
    return createdUserName;
  }

  /**
   * Sets the name of the user who created the record.
   *
   * @param createdUserName the new creator's user name
   */
  public void setCreatedUserName(String createdUserName) {
    this.createdUserName = createdUserName;
  }

  /**
   * Gets the name of the user who last modified the record.
   *
   * @return the modifier's user name
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * Sets the name of the user who last modified the record.
   *
   * @param modifiedUserName the new modifier's user name
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName;
  }
}
