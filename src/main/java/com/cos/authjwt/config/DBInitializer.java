package com.cos.authjwt.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cos.authjwt.domain.product.Product;
import com.cos.authjwt.domain.product.ProductRepository;
import com.cos.authjwt.domain.user.User;
import com.cos.authjwt.domain.user.UserRepository;

@Configuration
public class DBInitializer {

	private static final Logger log = LoggerFactory.getLogger(DBInitializer.class);

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, ProductRepository productRepository) {

		return (args) -> {
			List<User> users = new ArrayList<>();
			users.add(User.builder().username("ssar").password("1234").email("ssar@nate.com").build());
			users.add(User.builder().username("cos").password("1234").email("cos@nate.com").build());
			List<User> userEntitys = userRepository.saveAll(users);

			List<Product> products = new ArrayList<>();
			products.add(Product.builder().type(0)
					.title("제목1").count(1).price(4000000).texture("재질1").size("사이즈1")
					.productionDate(LocalDateTime.now()).yearOfManufacture("2022년도").country("한국").signInfo("작품뒤에 서명")
					.guarantee(true)
					.user(userEntitys.get(0)).build());

			products.add(Product.builder().type(0)
					.title("제목2").count(1).price(5000000).texture("재질2").size("사이즈3")
					.productionDate(LocalDateTime.now()).yearOfManufacture("2022년도").country("한국").signInfo("작품뒤에 서명")
					.guarantee(true)
					.user(userEntitys.get(0)).build());

			products.add(Product.builder().type(0)
					.title("제목3").count(1).price(4000000).texture("재질2").size("사이즈2")
					.productionDate(LocalDateTime.now()).yearOfManufacture("2022년도").country("한국").signInfo("작품뒤에 서명")
					.guarantee(true)
					.user(userEntitys.get(1)).build());

			productRepository.saveAll(products);
		};

	}
}
