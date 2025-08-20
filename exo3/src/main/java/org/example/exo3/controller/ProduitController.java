package org.example.exo3.controller;

import org.example.exo3.dto.ProduitReceiveDto;
import org.example.exo3.model.Produit;
import org.example.exo3.repository.ProduitRepository;
import org.example.exo3.service.PanierService;
import org.example.exo3.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Produit")
public class ProduitController {
    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public ResponseEntity<Produit> create(@RequestBody ProduitReceiveDto produitReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produitService.create(produitReceiveDto));
    }

    @GetMapping
    public ResponseEntity<List<Produit>> findAll() {
        return ResponseEntity.ok(this.produitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> get(@PathVariable int id) {
        return ResponseEntity.ok(this.produitService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        this.produitService.delete(id);
        return ResponseEntity.ok(String.format("Deleted produit with id %d", id));
    }
}
