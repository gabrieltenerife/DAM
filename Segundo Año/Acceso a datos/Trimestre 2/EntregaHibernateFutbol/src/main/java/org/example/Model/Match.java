package org.example.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "matchs", schema = "european_football")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_match", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "division")
    private Division division;

    @Column(name = "match_date")
    private LocalDate matchDate;

    @Column(name = "HomeTeam")
    private String homeTeam;

    @Column(name = "AwayTeam")
    private String awayTeam;

    @Column(name = "FTHG")
    private Double fthg;

    @Column(name = "FTAG")
    private Double ftag;

    @Column(name = "FTR")
    private String ftr;

    @Column(name = "season")
    private Integer season;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Double getFthg() {
        return fthg;
    }

    public void setFthg(Double fthg) {
        this.fthg = fthg;
    }

    public Double getFtag() {
        return ftag;
    }

    public void setFtag(Double ftag) {
        this.ftag = ftag;
    }

    public String getFtr() {
        return ftr;
    }

    public void setFtr(String ftr) {
        this.ftr = ftr;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", division=" + division.getName() +
                ", matchDate=" + matchDate +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", fthg=" + fthg +
                ", ftag=" + ftag +
                ", ftr='" + ftr + '\'' +
                ", season=" + season +
                '}';
    }
}