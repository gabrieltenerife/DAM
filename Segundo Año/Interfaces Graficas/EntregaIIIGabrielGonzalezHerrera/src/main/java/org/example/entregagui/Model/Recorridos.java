package org.example.entregagui.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.LinkedHashSet;
import java.util.Set;



@Getter
@Setter

@Entity
@Table(name = "Recorridos")
public class Recorridos {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "Nombre Recorrido")
    private String nombre;

    @Column (name = "Distancia")
    private int distancia;

    @Column (name = "Desnivel")
    private int desnivel;

}
