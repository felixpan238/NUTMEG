package org.nutmegsoccer.nutmeg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan
@EntityScan( basePackages = {"org.nutmegsoccer.nutmeg"} )
public class NutmegApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutmegApplication.class, args);
	}


}
