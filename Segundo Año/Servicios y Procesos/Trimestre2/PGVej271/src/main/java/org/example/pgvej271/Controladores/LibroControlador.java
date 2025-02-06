package org.example.pgvej271.Controladores;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.pgvej271.Datos.Libro;
import org.example.pgvej271.Repositorios.LibroRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
public class LibroControlador {
    private final LibroRepositorio libroRepositorio;

    @PostMapping
    public ResponseEntity<Libro> meterLibro(@RequestBody Libro libro) {
        Libro libroGuardado = libroRepositorio.save(libro);
        return ResponseEntity.ok(libroGuardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibro(@PathVariable Long id) {
        Optional<Libro> libro = libroRepositorio.findById(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Libro> obtenerLibros() {
        return libroRepositorio.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroRepositorio.findById(id)
                .map(existeLibro -> {
                    existeLibro.setIsbn(libro.getIsbn());
                    existeLibro.setTitulo(libro.getTitulo());
                    existeLibro.setAutores(libro.getAutores());
                    Libro actualizadoLibro = libroRepositorio.save(existeLibro);
                    return ResponseEntity.ok(actualizadoLibro);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarLibro(@PathVariable Long id) {
        if (libroRepositorio.existsById(id)) {
            libroRepositorio.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}