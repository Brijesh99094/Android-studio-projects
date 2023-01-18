package com.example.myreyclerview;

import java.io.Serializable;

public class Movie implements Serializable {

    int id ;
    String name,genre,poster;


    public Movie(int id, String name, String poster, String genre) {
        this.id = id;
        this.name = name;
        this.poster = poster;
        this.genre = genre;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
