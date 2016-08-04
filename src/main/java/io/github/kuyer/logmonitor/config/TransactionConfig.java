package io.github.kuyer.logmonitor.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@EnableTransactionManagement
public class TransactionConfig implements TransactionManagementConfigurer {
	
	@Autowired
	@Qualifier("txManager1")
	private PlatformTransactionManager txManager1;
	
	@Bean(name="txManager1")
	public PlatformTransactionManager txManager1(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name="txManager2")
	public PlatformTransactionManager txManager2(EntityManagerFactory em) {
		return new JpaTransactionManager(em);
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager1;
	}

}
