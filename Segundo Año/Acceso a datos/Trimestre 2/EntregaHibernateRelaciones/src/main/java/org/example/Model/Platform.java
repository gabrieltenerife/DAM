package org.example.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "platforms", schema = "rawg_games")
public class Platform {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "platforms", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Game> games = new LinkedHashSet<>();

}