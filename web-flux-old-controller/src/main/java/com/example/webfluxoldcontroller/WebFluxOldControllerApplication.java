package com.example.webfluxoldcontroller;

import com.example.webfluxoldcontroller.model.Product;
import com.example.webfluxoldcontroller.repository.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.stream.IntStream;

@SpringBootApplication
public class WebFluxOldControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxOldControllerApplication.class, args);
	}


	@Bean
	public ApplicationRunner runner(ProductRepository productRepository, MongoOperations mongoOperations) {
		return (args) -> {
			mongoOperations.dropCollection(Product.class);
			mongoOperations.createCollection(Product.class);
            IntStream.range(1, 10).forEach(i -> {
                productRepository.save(new Product(String.valueOf(i), "XPTO " + i)).subscribe();

            });
//			productRepository.save(new Product("23454", "Perfume XPTO")).subscribe();
//			productRepository.save(new Product("58786", "Maquiagem XPTO")).subscribe();
//			productRepository.save(new Product("78689", "Creme XPTO")).subscribe();
		};
	}
}
