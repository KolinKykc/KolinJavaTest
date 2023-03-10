package com.kolinjavatest.kolinjavatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kolinjavatest.kolinjavatest"})
@EnableAutoConfiguration
public class KolinJavaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KolinJavaTestApplication.class, args);
	}

}
