package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)
    {
        System.getProperties().put("projectName", "springApp");
		SpringApplication.run(DemoApplication.class, args);
	}

}

