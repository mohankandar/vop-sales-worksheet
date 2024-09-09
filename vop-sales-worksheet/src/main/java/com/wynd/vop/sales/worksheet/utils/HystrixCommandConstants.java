package com.wynd.vop.sales.worksheet.utils;

/**
 * The Class HystrixCommandConstants.
 */
public final class HystrixCommandConstants {

  /**
   * Worksheet Service Thread Pool Group.
   */
  public static final String PERSON_SERVICE_GROUP_KEY = "WorksheetServiceGroup";

  /**
   * Do not instantiate
   */
  private HystrixCommandConstants() {
    throw new UnsupportedOperationException("HystrixCommandConstants is a static class. Do not instantiate it.");
  }
}