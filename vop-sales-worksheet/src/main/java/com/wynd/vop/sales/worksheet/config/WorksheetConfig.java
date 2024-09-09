package com.wynd.vop.sales.worksheet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.wynd.vop.framework.audit"},
    excludeFilters = @Filter(Configuration.class))
public class WorksheetConfig {

}