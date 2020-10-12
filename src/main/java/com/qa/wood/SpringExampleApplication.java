package com.qa.wood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.wood.service.WoodService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringExampleApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringExampleApplication.class, args);
		System.out.println(ac.getBean(WoodService.class));
		// DEMO PURPOSES ONLY
	}

}
