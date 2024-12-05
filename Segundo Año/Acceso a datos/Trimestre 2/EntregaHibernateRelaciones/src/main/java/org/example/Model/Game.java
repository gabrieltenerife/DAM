package org.example.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "games", schema = "rawg_games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "slug")
    private String slug;

    @Column(name = "name")
    private String name;

    @Column(name = "released_date")
    private LocalDate releasedDate;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)

    private Set<Achievement> achievements = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "gamegenres", joinColumns = @JoinColumn(name = "game_id"),
    inverseJoinColumns =  @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "gameplatforms", joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns =  @JoinColumn(name = "platform_id") )
    private Set<Platform> platforms = new LinkedHashSet<>();

}