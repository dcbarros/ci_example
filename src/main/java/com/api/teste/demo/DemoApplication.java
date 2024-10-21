package com.api.teste.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "API ensino integração com bancos",
		version = "1.0",
		description = "Documentando uma API básica de gerenciamento de pedidos",
		contact = @Contact(name = "Davison", email = "dcbarros11@gmail.com", url = "https://www.github.com/dcbarros")
	)
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
