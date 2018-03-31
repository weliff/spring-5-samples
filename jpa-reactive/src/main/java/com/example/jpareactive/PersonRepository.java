package com.example.jpareactive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Async
    @Query("from Person")
    CompletableFuture<List<Person>> findAllAsync();
}
