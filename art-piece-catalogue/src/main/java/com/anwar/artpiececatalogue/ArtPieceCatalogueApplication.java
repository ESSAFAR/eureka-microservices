package com.anwar.artpiececatalogue;

import com.anwar.artpiececatalogue.entity.ArtPiece;
import com.anwar.artpiececatalogue.repository.ArtPieceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ArtPieceCatalogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtPieceCatalogueApplication.class, args);
    }

    @Bean
    CommandLineRunner coucou(ArtPieceRepository artPieceRepository){
        return args -> {
            artPieceRepository.save(new ArtPiece(1L, "The Starry Night", "Oil painting on canvas", "Post-Impressionism", "Nature", 1889, "Vincent van Gogh", 1L, 500000L, 1));
        };
    }

    @Bean
    @LoadBalanced //Now it's the find of eureka to do the load balancing
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
