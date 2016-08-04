package io.github.kuyer.logmonitor;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootApplication2 {
	
	@Bean
	public EmbeddedServletContainerFactory servletFactory() {
		TomcatEmbeddedServletContainerFactory container = new TomcatEmbeddedServletContainerFactory();
		container.setPort(8904);
		container.setSessionTimeout(10, TimeUnit.SECONDS);
		return container;
	}
	
	public static void mainx(String[] args) {
		SpringApplication.run(BootApplication2.class, args);
	}

}
