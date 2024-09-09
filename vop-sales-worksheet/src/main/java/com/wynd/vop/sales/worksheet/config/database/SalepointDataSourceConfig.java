package com.wynd.vop.sales.worksheet.config.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.wynd.vop.sales.worksheet.data.repository.salepoint",
        entityManagerFactoryRef = "salepointEntityManagerFactory",
        transactionManagerRef = "salepointTransactionManager"
)
public class SalepointDataSourceConfig {

  /**
   * Creates and configures the DataSource for the Salepoint database.
   *
   * @return the configured DataSource instance.
   */
  @Primary
  @Bean(name = "salepointDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.salepoint")
  public DataSource salepointDataSource() {
    return DataSourceBuilder.create()
            .type(com.zaxxer.hikari.HikariDataSource.class)
            .build();
  }

  /**
   * Creates and configures the EntityManagerFactory for the Salepoint database.
   *
   * @param dataSource       the DataSource to use for the EntityManagerFactory.
   * @param jpaVendorAdapter the JpaVendorAdapter to use for the EntityManagerFactory.
   * @return the configured LocalContainerEntityManagerFactoryBean instance.
   */
  @Primary
  @Bean(name = "salepointEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean salepointEntityManagerFactory(
          @Qualifier("salepointDataSource") DataSource dataSource,
          @Qualifier("salepointJpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setPackagesToScan("com.wynd.vop.sales.worksheet.data.entity");
    factoryBean.setPersistenceUnitName("salepointPU");
    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    return factoryBean;
  }

  /**
   * Creates and configures the TransactionManager for the Salepoint database.
   *
   * @param entityManagerFactory the EntityManagerFactory to use for the TransactionManager.
   * @return the configured PlatformTransactionManager instance.
   */
  @Primary
  @Bean(name = "salepointTransactionManager")
  public PlatformTransactionManager salepointTransactionManager(
          @Qualifier("salepointEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  /**
   * Creates and configures the JpaVendorAdapter for the Salepoint database.
   *
   * @return the configured JpaVendorAdapter instance.
   */
  @Primary
  @Bean(name = "salepointJpaVendorAdapter")
  public JpaVendorAdapter salepointJpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabasePlatform("org.hibernate.dialect.Oracle12cDialect");
    adapter.setGenerateDdl(false);
    adapter.setShowSql(true);
    return adapter;
  }
}
