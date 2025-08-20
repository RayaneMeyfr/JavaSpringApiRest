package org.example.exo4.config;

import org.example.exo4.model.Creature;
import org.example.exo4.model.CreatureType;
import org.example.exo4.repository.CreatureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(CreatureRepository creatureRepository) {
        return args -> {
            Random random = new Random();

            IntStream.rangeClosed(1, 50).forEach(i -> {
                Creature creature = Creature.builder()
                        .name("Creature-" + i)
                        .age(random.nextInt(500))
                        .weight(10 + (200 - 10) * random.nextDouble())
                        .dangerous(random.nextBoolean())
                        .creatureType(CreatureType.values()[random.nextInt(CreatureType.values().length)])
                        .build();

                creatureRepository.save(creature);
            });
        };
    }
}

