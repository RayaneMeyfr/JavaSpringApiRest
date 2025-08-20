package org.example.exo3.service;

import jakarta.servlet.http.HttpSession;
import org.example.exo3.model.Produit;
import org.example.exo3.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PanierService {
    private HttpSession session;
    private ProduitRepository produitRepository;

    public PanierService(HttpSession session, ProduitRepository produitRepository) {
        this.session = session;
        this.produitRepository = produitRepository;
    }

    public void add(int id) {
        Produit produit = this.produitRepository.findById(id).get();
        Map<Integer, Produit> map = (Map<Integer, Produit>) this.session.getAttribute("panier");
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(produit.getId(), produit);
        this.session.setAttribute("panier", map);
    }

    public void remove(int id) {
        Map<Integer, Produit> map = (Map<Integer, Produit>) this.session.getAttribute("panier");
        if (map != null) {
            map.remove(id);
        }
        this.session.setAttribute("panier", map);
    }

    public Map<Integer, Produit> getPanier() {
        return (Map<Integer, Produit>) this.session.getAttribute("panier");
    }

    public Map<String, Object> validePanier() {
        Map<Integer, Produit> map = (Map<Integer, Produit>) this.session.getAttribute("panier");
        if (map == null) {
            map = new HashMap<>();
        }
        double total = map.values().stream().mapToDouble(Produit::getPrix).sum();
        Map<String, Object> result = new HashMap<>();
        result.put("produits", map.values());
        result.put("total", total);

        this.session.removeAttribute("panier");
        return result;
    }

}
