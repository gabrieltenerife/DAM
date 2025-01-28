package org.example.entregagui.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "CiclistaLesion")
public class CiclistaLesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ciclista_id")
    private Ciclistas ciclista;

    @ManyToOne
    @JoinColumn(name = "lesion_id")
    private Lesiones lesion;

    @Column(name = "PiernaLesionada")
    private String piernaLesionada;

    @Column(name = "LesionPorCaida")
    private boolean lesionPorCaida;
}

