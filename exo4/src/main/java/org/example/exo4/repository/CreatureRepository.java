package org.example.exo4.repository;

import org.example.exo4.model.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CreatureRepository extends JpaRepository<Creature, Integer> {
}
