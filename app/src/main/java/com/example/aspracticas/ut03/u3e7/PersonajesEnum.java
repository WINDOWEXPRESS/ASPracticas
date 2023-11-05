package com.example.aspracticas.ut03.u3e7;

import com.example.aspracticas.R;

public enum PersonajesEnum {
    DONATELLO("donatello", R.drawable.donatello),MICHEALANGELO("michealangelo", R.drawable.michaelangelo),
    LEONARDO("leonardo", R.drawable.leonardo),RAFAEL("rafael", R.drawable.rafael);
    private final String nombre;

    private final int idImagen;
    PersonajesEnum(String nombre, int idImagen) {
        this.nombre = nombre;
        this.idImagen = idImagen;
    }
    public int getIdImagen() {
        return idImagen;
    }
    @Override
    public String toString() {
        return  nombre;
    }
}
