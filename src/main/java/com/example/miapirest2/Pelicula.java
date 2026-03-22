package com.example.miapirest2;

import jakarta.persistence.*;

@Entity
@Table(name ="peliculas")

public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String director;
    private int año;

    public Pelicula(){}

    public Pelicula( String titulo, String director, int año) {
        this.titulo = titulo;
        this.director = director;
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public int getAño() {
        return año;
    }

    public String getDirector() {
        return director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
