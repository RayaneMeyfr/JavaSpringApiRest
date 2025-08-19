package org.example.exo2.service;

import org.example.exo2.dto.FilmReceiveDto;
import org.example.exo2.exception.NotFoundException;
import org.example.exo2.model.Film;
import org.example.exo2.model.Realisateur;
import org.example.exo2.repository.FilmRepository;
import org.example.exo2.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private final RealisateurRepository realisateurRepository;


    public FilmService(FilmRepository filmRepository, RealisateurRepository realisateurRepository) {
        this.filmRepository = filmRepository;
        this.realisateurRepository = realisateurRepository;
    }

    public List<Film> get(){
        return this.filmRepository.findAll();
    }

    public Film createFilm(FilmReceiveDto filmReceiveDto) {
        Realisateur realisateur = this.realisateurRepository.findById(filmReceiveDto.getRealisateur()).orElseThrow(NotFoundException::new);
        return this.filmRepository.save(filmReceiveDto.dtoToEntity(realisateur));
    }

    public Film get(int id){
        return filmRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Film> get(String nom){
        return filmRepository.findByRealisateurNom(nom);
    }

    public Film update(int id, FilmReceiveDto filmReceiveDto) {
        Film filmFind = this.filmRepository.findById(id).orElseThrow(NotFoundException::new);
        Realisateur realisateur = this.realisateurRepository.findById(filmReceiveDto.getRealisateur()).orElseThrow(NotFoundException::new);
        Film filmGet = filmReceiveDto.dtoToEntity(realisateur);
        filmGet.setNom(filmFind.getNom());
        filmGet.setDateSortie(filmFind.getDateSortie());
        filmGet.setDuree(filmFind.getDuree());
        filmGet.setDescription(filmFind.getDescription());
        filmGet.setGenre(filmFind.getGenre());
        filmGet.setRealisateur(filmFind.getRealisateur());
        return filmRepository.save(filmGet);
    }

    public void delete(int id) {
        filmRepository.deleteById(id);
    }
}
