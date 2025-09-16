package org.iplacex.viviana.discografia.artistas;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IArtistaRepository extends MongoRepository<Artista, String> {
    
}
