package com.example.webmvcwithreactive;

import com.example.webmvcwithreactive.model.Product;
import com.example.webmvcwithreactive.repository.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class WebMvcWithReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebMvcWithReactiveApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(ProductRepository productRepository, MongoOperations mongoOperations) {
		return (args) -> {

			mongoOperations.dropCollection(Product.class);
			mongoOperations.createCollection(Product.class);
			productRepository.save(new Product("324324", "Shampoo XPTO")).subscribe();
			productRepository.save(new Product("23454", "Perfume XPTO")).subscribe();
			productRepository.save(new Product("58786", "Maquiagem XPTO")).subscribe();
			productRepository.save(new Product("78689", "Creme XPTO")).subscribe();

		};
	}
}
