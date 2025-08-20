package org.example.exo3.controller;

import org.example.exo3.dto.ProduitReceiveDto;
import org.example.exo3.model.Produit;
import org.example.exo3.service.PanierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/panier")
public class PanierController {
    PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @GetMapping
    public Map<Integer,Produit> getPanier() {
        return panierService.getPanier();
    }

    @GetMapping("/validate")
    public Map<String, Object> validatePanier() {
        return panierService.validePanier();
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> add(@PathVariable int id) {
        this.panierService.add(id);
        return ResponseEntity.ok(String.format("Add produit with id %d", id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        this.panierService.remove(id);
        return ResponseEntity.ok(String.format("Delete produit with id %d", id));
    }
}
