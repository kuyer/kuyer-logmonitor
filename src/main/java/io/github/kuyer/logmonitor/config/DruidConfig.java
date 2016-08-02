package io.github.kuyer.logmonitor.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	
	/**
	 * 配置数据源
	 * @return
	 */
	/**
	@Bean
	public DataSource druidDataSource(
			@Value("spring.datasource.driver-class-name") String driver,
			@Value("spring.datasource.url") String url,
			@Value("spring.datasource.username") String username,
			@Value("spring.datasource.password") String password) {
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(driver);
		dds.setUrl(url);
		dds.setUsername(username);
		dds.setPassword(password);
		return dds;
	}
	**/
	
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(new StatViewServlet());
		srb.addUrlMappings("/druid/*");
		srb.addInitParameter("allow", "192.168.56.110,127.0.0.1");// IP白名单 (没有配置或者为空，则允许所有访问)
		srb.addInitParameter("deny", "192.168.56.111");// IP黑名单 (存在共同时，deny优先于allow)
		srb.addInitParameter("loginUsername", "admin");// 用户名
		srb.addInitParameter("loginPassword", "111111");// 密码
		srb.addInitParameter("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
		return srb;
	}
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new WebStatFilter());
		frb.addUrlPatterns("/*");
		frb.addInitParameter("exclusions", "*.css,*.js,*.gif,*.jpg,*.ico,/druid/*");
		return frb;
	}

}
