package com.doganmehmet.app.taskmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.doganmehmet")
@EntityScan(basePackages = "com.doganmehmet")
@EnableJpaRepositories
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
}
