package org.example.exo2.controller;

import org.example.exo2.dto.FilmReceiveDto;
import org.example.exo2.model.Film;
import org.example.exo2.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/film")
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<Film>> findAll() {
        return ResponseEntity.ok(filmService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> get(@PathVariable int id) {
        return ResponseEntity.ok(filmService.get(id));
    }

    @GetMapping("/real/{nom}")
    public ResponseEntity<List<Film>> getByReal(@PathVariable String nom) {
        return ResponseEntity.ok(filmService.get(nom));
    }

    @PostMapping
    public ResponseEntity<Film> create(@RequestBody FilmReceiveDto filmReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.createFilm(filmReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> update(@PathVariable int id, @RequestBody FilmReceiveDto filmReceiveDto) {
        return ResponseEntity.ok(filmService.update(id, filmReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        filmService.delete(id);
        return ResponseEntity.ok(String.format("Deleted user with id %d", id));
    }
}
