package com.bootcamp.personal.active.loan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.util.logging.Logger;

@OpenAPIDefinition(info = @Info(
		title = "OpenAPI Documentation",
		version = "1.0.0",
		description = "OpenAPI Loan Application Documentation v1.0.0",
		contact = @Contact(name = "Roberto Jaison", email = "jaisonjv7@gmail.com", url = ""),
		license = @License(name = "MIT License", url = "https://choosealicense.com/licenses/mit/")
))
@EnableEurekaClient
@SpringBootApplication
public class PersonalActiveLoanApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(PersonalActiveLoanApplication.class.toString());
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	@Autowired
	private Environment env;

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemplate.dropCollection("personalactiveloan").subscribe();

		//logger.log(Level.INFO, env.getProperty("spring.application.name"));
		logger.info("Java version: " + env.getProperty("java.version"));
		logger.info("Application name: " + env.getProperty("spring.application.name"));
		logger.info("Properties file upload status: " + env.getProperty("my-own-app.properties.status"));
		logger.info("Swagger: http://localhost:" + env.getProperty("server.port") +"/" + env.getProperty("springdoc.swagger-ui.path"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonalActiveLoanApplication.class, args);
	}

}