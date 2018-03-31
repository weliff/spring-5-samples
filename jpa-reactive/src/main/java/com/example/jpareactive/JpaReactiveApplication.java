package com.example.jpareactive;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@EnableAsync
@SpringBootApplication
public class JpaReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaReactiveApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationReadyEvent(PersonRepository personRepository) {
		return (args) -> {
			personRepository.save(new Person());

			Mono.fromFuture(personRepository.findAllAsync())
					.flatMapMany(p -> Flux.just(p)).log()
					.subscribe(p -> System.out.println(Thread.currentThread().getName()));
		};
	}
}
