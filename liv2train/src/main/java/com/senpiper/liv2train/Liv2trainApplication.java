package com.senpiper.liv2train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.senpiper.liv2train.CONTROLLER.EnrollmentController;
import com.senpiper.liv2train.SERVICE.EnrollmentServiceIMPL;

@SpringBootApplication
@ComponentScan(basePackageClasses = {EnrollmentController.class,EnrollmentServiceIMPL.class})
public class Liv2trainApplication {

	public static void main(String[] args) {
		SpringApplication.run(Liv2trainApplication.class, args);
	}

}
