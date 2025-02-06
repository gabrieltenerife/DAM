package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "editoriales")
@Data
public class Editorial {
    @Id @GeneratedValue
    private long id;
    private String nombre;
    private String direccion;
}