package Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "libros")
@Data
public class Libro {
    @Id @GeneratedValue
    private long id;
    private String titulo;
    private String isbn;
    @ManyToMany
    private List<Autor> autores;
}
