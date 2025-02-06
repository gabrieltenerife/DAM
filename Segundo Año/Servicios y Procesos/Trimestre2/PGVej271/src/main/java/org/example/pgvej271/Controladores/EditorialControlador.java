package org.example.pgvej271.Controladores;

import lombok.RequiredArgsConstructor;
import org.example.pgvej271.Datos.Editorial;
import org.example.pgvej271.Repositorios.EditorialRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editoriales")
@RequiredArgsConstructor
public class EditorialControlador {
    private final EditorialRepositorio editorialRepositorio;

    @PostMapping
    public ResponseEntity<Editorial> agregarEditorial(@RequestBody Editorial editorial) {
        Editorial nuevaEditorial = editorialRepositorio.save(editorial);
        return ResponseEntity.ok(nuevaEditorial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> obtenerEditorial(@PathVariable Long id) {
        Optional<Editorial> editorial = editorialRepositorio.findById(id);
        return editorial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Editorial> obtenerEditoriales() {
        return editorialRepositorio.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editorial> actualizarEditorial(@PathVariable Long id, @RequestBody Editorial editorial) {
        return editorialRepositorio.findById(id)
                .map(existente -> {
                    existente.setNombre(editorial.getNombre());
                    existente.setDireccion(editorial.getDireccion());
                    Editorial actualizada = editorialRepositorio.save(existente);
                    return ResponseEntity.ok(actualizada);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEditorial(@PathVariable Long id) {
        if (editorialRepositorio.existsById(id)) {
            editorialRepositorio.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}