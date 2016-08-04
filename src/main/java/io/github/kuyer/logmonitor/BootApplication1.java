package io.github.kuyer.logmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

//@SpringBootApplication
public class BootApplication1 implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8903);
	}
	
	public static void mainx(String[] args) {
		SpringApplication.run(BootApplication1.class, args);
	}

}
