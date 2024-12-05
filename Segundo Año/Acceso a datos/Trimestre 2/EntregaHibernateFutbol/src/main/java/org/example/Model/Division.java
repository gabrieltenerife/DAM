package org.example.Model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "divisions", schema = "european_football")
public class Division {
    @Id
    @Column(name = "division", nullable = false)
    private String division;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "division")
    private Set<Match> matchs = new LinkedHashSet<>();

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(Set<Match> matchs) {
        this.matchs = matchs;
    }

    @Override
    public String toString() {
        return "Division{" +
                "division='" + division + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", matchs=" + matchs +
                '}';
    }
}