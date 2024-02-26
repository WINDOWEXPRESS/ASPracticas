package com.example.aspracticas.ut9.plantillaexamen.datos;

import java.io.Serializable;
import java.util.List;

public class PeliculaPojo implements Serializable {
    private String nombre;
    private String descripcion;
    private String estrellas;
    private List<Actor> actores;

    public PeliculaPojo(String nombre, String descripcion, String estrellas ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estrellas = estrellas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public List<Actor> getActores() {
        return actores;
    }

    private class Actor implements Serializable{
        private String url;
        private String nombre;
        private String pelicula;

        public String getUrl() {
            return url;
        }

        public String getNombre() {
            return nombre;
        }

        public String getPelicula() {
            return pelicula;
        }
    }

}
