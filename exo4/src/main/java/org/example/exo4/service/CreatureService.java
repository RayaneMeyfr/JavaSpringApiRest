package org.example.exo4.service;

import org.example.exo4.dto.CreatureReceiveDto;
import org.example.exo4.model.Creature;
import org.example.exo4.repository.CreatureRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureService {
    private CreatureRepository creatureRepository;

    public CreatureService(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public Creature create(CreatureReceiveDto creature) {
        return this.creatureRepository.save(creature.dtoToEntity());
    }

    public List<Creature> getCreatures() {
        return this.creatureRepository.findAll();
    }

    public Creature getCreatureById(int id) {
        return creatureRepository.findById(id).orElse(null);
    }

    public Creature updateCreature(int id, CreatureReceiveDto creature) {
        Creature creatureToUpdate = this.creatureRepository.findById(id).orElse(null);
        creatureToUpdate.setName(creature.getName());
        creatureToUpdate.setAge(creature.getAge());
        creatureToUpdate.setDangerous(creature.isDangerous());
        creatureToUpdate.setWeight(creature.getWeight());
        creatureToUpdate.setCreatureType(creature.getCreatureType());
        return this.creatureRepository.save(creatureToUpdate);
    }

    public void deleteCreatureById(int id) {
        creatureRepository.deleteById(id);
    }

    // Pagination
    public Page<Creature> getPage(Pageable pageable) {
        return creatureRepository.findAll(pageable);
    }


}
