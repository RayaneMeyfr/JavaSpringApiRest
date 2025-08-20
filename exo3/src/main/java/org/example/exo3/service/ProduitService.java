package org.example.exo3.service;

import org.example.exo3.dto.ProduitReceiveDto;
import org.example.exo3.model.Produit;
import org.example.exo3.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    private ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit create(ProduitReceiveDto produit) {
        return produitRepository.save(produit.dtoToProduit());
    }

    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    public Produit findById(int id) {
        return produitRepository.findById(id).orElse(null);
    }

    public Produit update(int id, ProduitReceiveDto produit) {
        Produit produitFind = produitRepository.findById(id).orElse(null);
        produitFind.setNom(produit.getNom());
        produitFind.setPrix(produit.getPrix());
        return produitRepository.save(produitFind);
    }

    public void delete(int id) {
        produitRepository.deleteById(id);
    }
}
