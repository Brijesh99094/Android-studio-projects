package com.example.zulfin.recyclerviewdemo;

import java.io.Serializable;

public class Movie implements Serializable {
    int id;
    String name, poster, genre;

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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "com.example.zulfin.recyclerviewdemo.Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poster='" + poster + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

