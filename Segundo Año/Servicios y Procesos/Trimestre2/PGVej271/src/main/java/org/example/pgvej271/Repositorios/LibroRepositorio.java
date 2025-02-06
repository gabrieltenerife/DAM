package org.example.pgvej271.Repositorios;

import org.example.pgvej271.Datos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
}
