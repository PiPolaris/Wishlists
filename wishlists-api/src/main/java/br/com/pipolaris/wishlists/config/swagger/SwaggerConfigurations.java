package br.com.pipolaris.wishlists.config.swagger;

import org.springframework.boot.actuate.endpoint.http.ActuatorMediaType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	@Bean	
	public Docket forumAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.pipolaris.wishlists"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(ActuatorMediaType.class);
	}
}
