package org.example.pgvej271.Controladores;

import lombok.RequiredArgsConstructor;
import org.example.pgvej271.Datos.Autor;
import org.example.pgvej271.Repositorios.AutorRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorControlador {
    private final AutorRepositorio autorRepositorio;

    @PostMapping
    public ResponseEntity<Autor> agregarAutor(@RequestBody Autor autor) {
        Autor nuevoAutor = autorRepositorio.save(autor);
        return ResponseEntity.ok(nuevoAutor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutor(@PathVariable Long id) {
        Optional<Autor> autor = autorRepositorio.findById(id);
        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Autor> obtenerAutores() {
        return autorRepositorio.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        return autorRepositorio.findById(id)
                .map(existente -> {
                    existente.setNombre(autor.getNombre());
                    existente.setBiografia(autor.getBiografia());
                    existente.setEditoriales(autor.getEditoriales());
                    Autor actualizado = autorRepositorio.save(existente);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarAutor(@PathVariable Long id) {
        if (autorRepositorio.existsById(id)) {
            autorRepositorio.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}