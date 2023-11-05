package com.example.aspracticas.ut03.u3e7;

import android.util.ArraySet;

import com.example.aspracticas.R;

public enum ArmasEnum {
    AK47("ak47",R.drawable.ak_47),DOUBLE_PISTOLA("doublePistolas",R.drawable.doble_pistola),
    AMETRALLADORA("ametralladora",R.drawable.ametralladora),RIFLE("rifle",R.drawable.rifle);
    private final String nombre;
    private final int idImagen;
    ArmasEnum(String nombre, int idImagen) {
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
