package com.project.sundo_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.sundo_project", "com.project.sundo_project.config"})
public class SundoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SundoProjectApplication.class, args);

		System.out.println("good");
	}

}

