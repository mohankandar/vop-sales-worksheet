package com.wynd.vop.sales.worksheet;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The main entry point for the Worksheet application.
 * <p>
 * This class is annotated with {@link SpringBootApplication} to enable Spring Boot features.
 * It also enables caching with {@link EnableCaching} and asynchronous processing with
 * {@link EnableAsync}. Additionally, it provides a bean for Zipkin tracing with
 * {@link Sampler#ALWAYS_SAMPLE}.
 * </p>
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
public class WoksheetApplication {

  /**
   * The main method to run the Spring Boot application.
   * <p>
   * This method is the entry point of the application and will start the Spring Boot application
   * with the specified command-line arguments.
   * </p>
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(WoksheetApplication.class, args);
  }

  /**
   * Provides a {@link Sampler} bean that always samples traces for Zipkin.
   * <p>
   * This bean is used for tracing and will always sample traces, which is useful for
   * debugging and monitoring.
   * </p>
   *
   * @return the {@link Sampler} that always samples
   */
  @Bean
  Sampler alwaysSampler() {
    return Sampler.ALWAYS_SAMPLE;
  }
}
