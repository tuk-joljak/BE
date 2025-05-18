package com.example.graduation_work_BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class GraduationWorkBeApplication {

	public static void main(String[] args) {
		System.out.println("hi ci/cd test");
		SpringApplication.run(GraduationWorkBeApplication.class, args);
	}

}