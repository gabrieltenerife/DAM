package org.example;

public class Juego {
    String game, platform, developer, genere, number_players, rating, release_date,
            positive_critics, neutral_critics, negative_critics, positive_users,
            neutral_users, negative_users, metascore, users_score;

    public Juego(String game, String platform, String developer, String genere, String number_players, String rating, String release_date, String positive_critics, String neutral_critics, String negative_critics, String positive_users, String neutral_users, String negative_users, String metascore, String users_score) {
        this.game = game;
        this.platform = platform;
        this.developer = developer;
        this.genere = genere;
        this.number_players = number_players;
        this.rating = rating;
        this.release_date = release_date;
        this.positive_critics = positive_critics;
        this.neutral_critics = neutral_critics;
        this.negative_critics = negative_critics;
        this.positive_users = positive_users;
        this.neutral_users = neutral_users;
        this.negative_users = negative_users;
        this.metascore = metascore;
        this.users_score = users_score;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getNumber_players() {
        return number_players;
    }

    public void setNumber_players(String number_players) {
        this.number_players = number_players;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPositive_critics() {
        return positive_critics;
    }

    public void setPositive_critics(String positive_critics) {
        this.positive_critics = positive_critics;
    }

    public String getNeutral_critics() {
        return neutral_critics;
    }

    public void setNeutral_critics(String neutral_critics) {
        this.neutral_critics = neutral_critics;
    }

    public String getNegative_critics() {
        return negative_critics;
    }

    public void setNegative_critics(String negative_critics) {
        this.negative_critics = negative_critics;
    }

    public String getPositive_users() {
        return positive_users;
    }

    public void setPositive_users(String positive_users) {
        this.positive_users = positive_users;
    }

    public String getNeutral_users() {
        return neutral_users;
    }

    public void setNeutral_users(String neutral_users) {
        this.neutral_users = neutral_users;
    }

    public String getNegative_users() {
        return negative_users;
    }

    public void setNegative_users(String negative_users) {
        this.negative_users = negative_users;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getUsers_score() {
        return users_score;
    }

    public void setUsers_score(String users_score) {
        this.users_score = users_score;
    }
}