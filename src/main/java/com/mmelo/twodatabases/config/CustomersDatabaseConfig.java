package com.mmelo.twodatabases.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.mmelo.twodatabases.customers.repository",
        entityManagerFactoryRef = "customersEntityManagerFactory",
        transactionManagerRef = "customersTransactionManager"
)
public class CustomersDatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "customers-datasource")
    @Primary
    public DataSource customerDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean customersEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("customerDatasource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.mmelo.twodatabases.customers.domain")
                .persistenceUnit("customers")
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager customersTransactionManager(
            @Qualifier("customersEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
