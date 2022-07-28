package app;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DbConfig {

	@Bean
	public DataSource dataSource() {
		PGSimpleDataSource ds = new PGSimpleDataSource();
//		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://192.168.12.190:5432/base_1");
		ds.setUser("base");
		ds.setPassword("akuan");
		ds.setReWriteBatchedInserts(true);
		return ds;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		// vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");

		// Use these properties to let spring work on batch insertion
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.jdbc.batch_size", 1000);
		jpaProperties.put("hibernate.order_inserts", true);
		jpaProperties.put("hibernate.order_updates", true);
		jpaProperties.put("hibernate.batch_versioned_data", "true");
//		jpaProperties.put("hibernate.show_sql", true);
//		jpaProperties.put("hibernate.generate_statistics", true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(jpaProperties);
		factory.setPackagesToScan("app");
		factory.setDataSource(dataSource);
		factory.afterPropertiesSet();
		return factory.getObject();
	}
}
