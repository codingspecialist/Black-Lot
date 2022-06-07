package com.cos.authjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlackLotApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackLotApplication.class, args);
	}

}
