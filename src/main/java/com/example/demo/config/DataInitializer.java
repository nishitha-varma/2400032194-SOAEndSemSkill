package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Tourist;
import com.example.demo.repository.TouristRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(TouristRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Tourist t1 = new Tourist();
                t1.setName("Aarav Sharma");
                t1.setDestination("Goa");
                t1.setContact("9876543210");

                Tourist t2 = new Tourist();
                t2.setName("Priya Nair");
                t2.setDestination("Manali");
                t2.setContact("9123456780");

                Tourist t3 = new Tourist();
                t3.setName("Rohan Verma");
                t3.setDestination("Jaipur");
                t3.setContact("9988776655");

                repository.save(t1);
                repository.save(t2);
                repository.save(t3);
            }
        };
    }
}
