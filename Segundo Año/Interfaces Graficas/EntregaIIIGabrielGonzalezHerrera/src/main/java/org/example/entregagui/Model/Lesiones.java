package org.example.entregagui.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "Lesiones")
public class Lesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FechaLesion")
    private LocalDate fechaLesion;

    @Column(name = "MesesRecuperaccion")
    private int mesesRecuperacion;

    @ManyToMany(mappedBy = "lesiones")
    private List<Ciclistas> ciclistas;
}

