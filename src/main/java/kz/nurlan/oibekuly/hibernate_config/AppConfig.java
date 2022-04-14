
package kz.nurlan.oibekuly.hibernate_config;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "kz.nurlan.oibekuly")
@PropertySource(value = "application.properties")
@EnableTransactionManagement
@Component
@EnableJpaRepositories(basePackages = "kz.nurlan.oibekuly")
@EntityScan(basePackages = "kz.nurlan.oibekuly")
public class AppConfig {

    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            DriverManagerDataSource driver = new DriverManagerDataSource();
            driver.setDriverClassName("org.h2.Driver");
            driver.setUrl("jdbc:h2:mem:oibekuly");
            driver.setUsername("sa");
            driver.setPassword("");
            return driver;
        }  catch (Exception e) {
            logger.error("Error identifiying datasource", e);
            return null;
        }
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    private Properties hibernateProperties() {
        Properties hibernateProperty = new Properties();
        hibernateProperty.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperty.put("hibernate.format_sql", true);
        hibernateProperty.put("hibernate.use_sql_comments", true);
        hibernateProperty.put("hibernate.show_sql", false);
        hibernateProperty.put("hibernate.max_fetch_depth", 3);
        hibernateProperty.put("hibernate.jdbc.batch_size", 10);
        hibernateProperty.put("hibernate.jdbc.fetch_size", 50);
        hibernateProperty.put("hibernate.connection.driver_class", "org.h2.Driver");
        hibernateProperty.put("hibernate.connection.URL", "jdbc:h2:mem:oibekuly");
        hibernateProperty.put("hibernate.connection.username", "sa");
        hibernateProperty.put("hibernate.connection.password", "");
        hibernateProperty.put("hibernate.ddl.auto", "none");
        return hibernateProperty;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("kz.nurlan.oibekuly");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }


}

