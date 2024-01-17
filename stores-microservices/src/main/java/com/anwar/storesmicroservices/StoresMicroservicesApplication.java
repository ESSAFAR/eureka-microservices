package com.anwar.storesmicroservices;

import com.anwar.storesmicroservices.entity.Store;
import com.anwar.storesmicroservices.repository.StoresRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoresMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoresMicroservicesApplication.class, args);
    }


    @Bean
    CommandLineRunner coucou(StoresRepository storesRepository){
        return args -> {
            storesRepository.save(new Store(1L, "Art Gallery", "info@artgallery.com", "United States", "A premier art gallery showcasing contemporary and classic artworks."));
        };
    }

}
