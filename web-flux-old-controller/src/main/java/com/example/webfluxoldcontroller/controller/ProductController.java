package com.example.webfluxoldcontroller.controller;

import com.example.webfluxoldcontroller.model.Product;
import com.example.webfluxoldcontroller.repository.ProductRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Flux<Product> findAll() {
        return productRepository.findAll().log().delayElements(Duration.ofSeconds(1));
    }
}
