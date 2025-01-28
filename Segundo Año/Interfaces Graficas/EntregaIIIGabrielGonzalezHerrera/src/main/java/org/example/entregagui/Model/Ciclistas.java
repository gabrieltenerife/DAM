package org.example.entregagui.Model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

@Entity
@Table(name = "Ciclistas")
public class Ciclistas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Bicicleta")
    private String bicicleta;

    @ManyToOne
    private Pelotones pelotones;

    @ManyToMany
    @JoinTable(
            name = "CiclistaLesion",
            joinColumns = @JoinColumn(name = "ciclista_id"),
            inverseJoinColumns = @JoinColumn(name = "lesion_id")
    )
    private List<Lesiones> lesiones;
}

