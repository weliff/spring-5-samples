package com.example.webfluxoldcontroller.repository;


import com.example.webfluxoldcontroller.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
