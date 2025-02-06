package Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "autores")
@Data
public class Autor {
    @Id @GeneratedValue
    private long id;
    private String nombre;
    private String biografia;
    @ManyToOne
    private Editorial editoriales;
}
