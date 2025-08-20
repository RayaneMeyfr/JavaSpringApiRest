package org.example.exo4.controller;

import jakarta.validation.Valid;
import org.example.exo4.dto.CreatureReceiveDto;
import org.example.exo4.model.Creature;
import org.example.exo4.service.CreatureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/creature")
public class CreatureController {
    CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    @PostMapping
    public ResponseEntity<Creature> create(@RequestBody @Valid  CreatureReceiveDto creatureReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.creatureService.create(creatureReceiveDto));
    }

    @GetMapping
    public ResponseEntity<List<Creature>> findAll() {
        return ResponseEntity.ok(this.creatureService.getCreatures());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Creature> get(@PathVariable int id) {
        return ResponseEntity.ok(this.creatureService.getCreatureById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        this.creatureService.deleteCreatureById(id);
        return ResponseEntity.ok(String.format("Deleted produit with id %d", id));
    }

    @GetMapping("/paged")
    public Page<Creature> getPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return creatureService.getPage(PageRequest.of(page, size));
    }


}
