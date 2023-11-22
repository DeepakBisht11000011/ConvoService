package com.deepweb.convo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.deepweb.convo.repository")
public class ConvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvoApplication.class, args);
	}

}
