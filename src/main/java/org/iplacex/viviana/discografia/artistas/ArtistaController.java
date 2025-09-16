package org.iplacex.viviana.discografia.artistas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ArtistaController {
    @Autowired
    private IArtistaRepository repository;

    @PostMapping(value = "/artistas", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artista> HandleInsertArtistaRequest(
            @RequestBody Artista artista) {
        Artista temp = repository.insert(artista);
        return new ResponseEntity<>(temp, null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/artistas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Artista>> HandleGetAllArtistasRequest() {
        List<Artista> temp = repository.findAll();
        return new ResponseEntity<>(temp, null, HttpStatus.OK);
    }

    @GetMapping(value = "/artista/{id}", produces = "application/json")
    public ResponseEntity<Artista> HandleGetArtistaRequest(
            @PathVariable("id") String id) {
        Optional<Artista> temp = repository.findById(id);
        if (temp.isPresent()) {
            return new ResponseEntity<>(temp.get(), null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/artista/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artista> HandleUpdateArtistaRequest(
            @PathVariable("id") String id,
            @RequestBody Artista artAct) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
        artAct._id = id;
        Artista temp = repository.save(artAct);
        return new ResponseEntity<>(temp, null, HttpStatus.OK);
    }

    @DeleteMapping(value = "/artista/{id}")
    public ResponseEntity<Artista> HandleDeleteArtistaRequest(
            @PathVariable("id") String id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
        Artista temp = repository.findById(id).get();
        repository.deleteById(id);
        return new ResponseEntity<>(temp, null, HttpStatus.OK);

    }

}
