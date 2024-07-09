package com.certus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.certus.spring.models") 
public class PangeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PangeaApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
		return (factory) -> factory.addConnectorCustomizers((connector) -> {
			connector.setProperty("maxSwallowSize", "-1");
		});
	}
}
