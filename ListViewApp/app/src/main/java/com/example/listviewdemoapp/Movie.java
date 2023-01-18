package com.example.listviewdemoapp;

import java.io.Serializable;

public class Movie implements Serializable {
    int id;
    String name,poster,genre;

    public Movie(int id,String name,String poster,String genre){
        this.id = id;
        this.name=name;
        this.genre = genre;
        this.poster= poster;
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
    public  String toString(){
        return "com.example.zulfin.listviewdemo.Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poster='" + poster + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
