package org.iplacex.viviana.discografia.discos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DiscoController {

    @Autowired
    private IDiscoRepository repository;

    @PostMapping(
        value = "/discos", 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> HandlePostDiscoRequest(@RequestBody Disco disco) {
        Disco temp = repository.insert(disco);
        return new ResponseEntity<>(temp, null, HttpStatus.CREATED);
    }

    @GetMapping(
        value = "/discos", 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disco>> HandleGetDiscosRequest() {
        List<Disco> temp = repository.findAll();
        return new ResponseEntity<>(temp, null, HttpStatus.OK);
    }

    @GetMapping(
        value = "/disco/{id}", 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> HandleGetDiscoRequest(@PathVariable("id") String id) {
        Optional<Disco> temp = repository.findById(id);
        if (temp.isPresent()) {
            return new ResponseEntity<>(temp.get(), null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(
        value = "/discos/artista/{idArtista}", 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disco>> HandleGetDiscosByArtistaRequest(
        @PathVariable("idArtista") String idArtista) {
        List<Disco> temp = repository.findDiscosByIdArtista(idArtista);
        return new ResponseEntity<>(temp, null, HttpStatus.OK);
    }
}