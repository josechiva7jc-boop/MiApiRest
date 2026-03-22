package com.example.miapirest2;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double nota;

    public Estudiante() {}  // ← este también es necesario para JPA

    public Estudiante(String nombre, double nota) {  // ← sin id, lo genera la BD
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getNota() { return nota; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNota(double nota) { this.nota = nota; }
}