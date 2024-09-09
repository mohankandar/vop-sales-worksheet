package com.wynd.vop.sales.worksheet.config;

import com.wynd.vop.framework.security.HttpProperties;
import com.wynd.vop.sales.worksheet.WorksheetProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for handling CORS (Cross-Origin Resource Sharing) settings
 * for the Worksheet service.
 */
@Configuration
public class WorksheetCorsConfig {

  private final WorksheetProperties worksheetProperties;
  private final HttpProperties httpProperties;

  /**
   * Constructs a new {@code WorksheetCorsConfig} with the specified properties.
   *
   * @param worksheetProperties The properties specific to the Worksheet service.
   * @param httpProperties   The HTTP-related properties including CORS settings.
   */
  public WorksheetCorsConfig(@Autowired WorksheetProperties worksheetProperties,
                          @Autowired HttpProperties httpProperties) {
    this.worksheetProperties = worksheetProperties;
    this.httpProperties = httpProperties;
  }

  /**
   * Configures CORS settings for the application.
   *
   * @return A {@code WebMvcConfigurer} bean that applies the CORS configuration.
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        if (httpProperties.getCors() != null && httpProperties.getCors().isEnabled()) {
          // UIEnablement
          // The usage of the word orIgIn in all lower case is problematic in the gen.sh script.
          // After generation, the scripts will replace with all lower case version or camel case version and uncomment as necessary.
          // UIEnablement: registry.addMapping("/api/v1/worksheet/**").allowedOrigins(worksheetProperties.getOrIgIns());
        }
      }
    };
  }
}
