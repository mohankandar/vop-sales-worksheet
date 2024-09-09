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
        basePackages = "com.wynd.vop.sales.worksheet.data.repository.wsa",
        entityManagerFactoryRef = "wsaEntityManagerFactory",
        transactionManagerRef = "wsaTransactionManager"
)
public class WsaDataSourceConfig {

  /**
   * Creates and configures the DataSource for the WSA database.
   *
   * @return the configured DataSource instance.
   */
  @Primary
  @Bean(name = "wsaDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.wsa")
  public DataSource wsaDataSource() {
    return DataSourceBuilder.create()
            .type(com.zaxxer.hikari.HikariDataSource.class)
            .build();
  }

  /**
   * Creates and configures the EntityManagerFactory for the WSA database.
   *
   * @param dataSource       the DataSource to use for the EntityManagerFactory.
   * @param jpaVendorAdapter the JpaVendorAdapter to use for the EntityManagerFactory.
   * @return the configured LocalContainerEntityManagerFactoryBean instance.
   */
  @Primary
  @Bean(name = "wsaEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean wsaEntityManagerFactory(
          @Qualifier("wsaDataSource") DataSource dataSource,
          @Qualifier("wsaJpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setPackagesToScan("com.wynd.vop.sales.worksheet.data.entity");
    factoryBean.setPersistenceUnitName("wsaPU");
    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    return factoryBean;
  }

  /**
   * Creates and configures the TransactionManager for the WSA database.
   *
   * @param entityManagerFactory the EntityManagerFactory to use for the TransactionManager.
   * @return the configured PlatformTransactionManager instance.
   */
  @Primary
  @Bean(name = "wsaTransactionManager")
  public PlatformTransactionManager wsaTransactionManager(
          @Qualifier("wsaEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  /**
   * Creates and configures the JpaVendorAdapter for the WSA database.
   *
   * @return the configured JpaVendorAdapter instance.
   */
  @Bean(name = "wsaJpaVendorAdapter")
  public JpaVendorAdapter wsaJpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabasePlatform("org.hibernate.dialect.Oracle12cDialect");
    adapter.setGenerateDdl(false);
    adapter.setShowSql(true);
    return adapter;
  }
}
