package org.example.exo2.controller;

import org.example.exo2.dto.RealisateurReceiveDto;
import org.example.exo2.model.Realisateur;
import org.example.exo2.service.RealisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/realisateur")
public class RealisateurController {
    private final RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public ResponseEntity<List<Realisateur>> findAll() {
        return ResponseEntity.ok(realisateurService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Realisateur> get(@PathVariable int id) {
        return ResponseEntity.ok(realisateurService.get(id));
    }

    @PostMapping
    public ResponseEntity<Realisateur> create(@RequestBody RealisateurReceiveDto realisateurReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(realisateurService.createRealisateur(realisateurReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Realisateur> update(@PathVariable int id, @RequestBody RealisateurReceiveDto realisateurReceiveDto) {
        return ResponseEntity.ok(realisateurService.update(id, realisateurReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        realisateurService.delete(id);
        return ResponseEntity.ok(String.format("Deleted user with id %d", id));
    }
}
