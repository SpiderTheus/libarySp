package com.spidertech.libarySp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {
		  MultipartAutoConfiguration.class,
		  JmxAutoConfiguration.class,
		})
@ComponentScan(basePackages = "com.spidertech.libarySp")
public class LibarySpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibarySpApplication.class, args);
	}

}