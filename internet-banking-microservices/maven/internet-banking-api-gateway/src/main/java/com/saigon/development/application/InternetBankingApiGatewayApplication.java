package com.saigon.development.application;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee API", version = "1.0", description = "Documentation Employee API v1.0"))
public class InternetBankingApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetBankingApiGatewayApplication.class, args);
	}

	@Autowired
	RouteDefinitionLocator locator;

	@Bean
	public List<GroupedOpenApi> apis() {
		List<GroupedOpenApi> groups = new ArrayList<>();
		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
		assert definitions != null;
		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
				.forEach(routeDefinition -> {
					String name = routeDefinition.getId().replaceAll("-service", "");
					GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
				});
		return groups;
	}

}
