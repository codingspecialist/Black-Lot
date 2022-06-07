package com.cos.authjwt.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cos.authjwt.domain.user.User;
import com.cos.authjwt.domain.user.UserRepository;

@Configuration
public class DBInitializer {

	private static final Logger log = LoggerFactory.getLogger(DBInitializer.class);

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {

		return (args) -> {
			List<User> users = new ArrayList<>();
			users.add(User.builder().username("ssar").password("1234").email("ssar@nate.com").build());
			users.add(User.builder().username("cos").password("1234").email("cos@nate.com").build());
			userRepository.saveAll(users);
		};
	}
}
