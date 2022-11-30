package br.com.helpin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class HelpinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpinApiApplication.class, args);
	}

}
