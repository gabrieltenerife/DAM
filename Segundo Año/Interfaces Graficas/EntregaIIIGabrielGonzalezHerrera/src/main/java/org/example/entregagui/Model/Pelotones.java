package org.example.entregagui.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table (name = "Pelotones")
public class Pelotones {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "Nombre")
    private String nombre;

    @Column (name = "Ritmo")
    private String ritmo;

    @ManyToMany
    Set<Recorridos> recorridos = new LinkedHashSet<>();
}
