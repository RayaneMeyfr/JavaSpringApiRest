package org.example.exo2.service;

import org.example.exo2.dto.RealisateurReceiveDto;
import org.example.exo2.exception.NotFoundException;
import org.example.exo2.model.Realisateur;
import org.example.exo2.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    public Realisateur createRealisateur(RealisateurReceiveDto realisateurReceiveDto) {
        return this.realisateurRepository.save(realisateurReceiveDto.dtoToEntity());
    }

    public List<Realisateur> get(){
        return this.realisateurRepository.findAll();
    }


    public Realisateur get(int id){
        return this.realisateurRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Realisateur update(int id, RealisateurReceiveDto realisateurReceiveDto) {
        Realisateur realisateurFind = this.realisateurRepository.findById(id).orElseThrow(NotFoundException::new);
        Realisateur realisateurGet = realisateurReceiveDto.dtoToEntity();
        realisateurGet.setNom(realisateurFind.getNom());
        realisateurGet.setPrenom(realisateurFind.getPrenom());
        realisateurGet.setDateNaissance(realisateurFind.getDateNaissance());
        realisateurGet.setNationalite(realisateurFind.getNationalite());
        realisateurGet.setFilms(realisateurFind.getFilms());
        return realisateurRepository.save(realisateurGet);
    }

    public void delete(int id) {
        realisateurRepository.deleteById(id);
    }
}
