package de.stattauto.fuhrpark;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.stattauto.fuhrpark.entity.Auto;
import de.stattauto.fuhrpark.repository.FuhrparkRepository;

@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories
public class Fuhrpark2Application {

	public static void main(String[] args) {
		SpringApplication.run(Fuhrpark2Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(FuhrparkRepository repo) {
		return args -> {
			repo.save(new Auto("neu", "Haupstelle", "F SA101"));
			repo.save(new Auto("in Ordnung", "Haupstelle", "F SA102"));
			repo.save(new Auto("in Ordnung", "Standort a", "F SA103"));
			repo.save(new Auto("defekt", "Werkstadt", "F SA104"));
		};
	}
}
