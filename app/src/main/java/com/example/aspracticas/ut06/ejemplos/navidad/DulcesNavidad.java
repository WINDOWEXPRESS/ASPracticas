package com.example.aspracticas.ut06.ejemplos.navidad;

import com.example.aspracticas.ut06.ejemplos.partidos.Partido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DulcesNavidad {
    private static final int MAX_CALORIA = 10000;
    private String nombre;
    private boolean frutoSeco;
    private double caloria;
    // Crear una ArrayList de frutos secos
    private static List<String> listaDulcesNavidad = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public boolean isFrutoSeco() {
        return frutoSeco;
    }

    public double getCaloria() {
        return caloria;
    }

    private static DulcesNavidad generarDulceNavidad() {
        addDulcesNavidad();
        Collections.shuffle(listaDulcesNavidad);
        DulcesNavidad dulcesNavidad = new DulcesNavidad();
        dulcesNavidad.nombre= listaDulcesNavidad.get(0);
        dulcesNavidad.caloria = (Math.random() * MAX_CALORIA);
        // utiliza la clase Random para generar un valor booleano aleatorio con nextBoolean().
        Random random = new Random();
        dulcesNavidad.frutoSeco =  random.nextBoolean();
        return dulcesNavidad;
    }
    private static void addDulcesNavidad(){
        // Agregar los dulces a la lista
        listaDulcesNavidad.add("Turrón");
        listaDulcesNavidad.add("Polvorón");
        listaDulcesNavidad.add("Mantecado");
        listaDulcesNavidad.add("Pestiños");
        listaDulcesNavidad.add("Roscón de Reyes");
        listaDulcesNavidad.add("Mazapán");
        listaDulcesNavidad.add("Rosco de vino");
        listaDulcesNavidad.add("Yemas de Santa Teresa");
        listaDulcesNavidad.add("Guirlache");
        listaDulcesNavidad.add("Neules");
        listaDulcesNavidad.add("Casadielles");
        listaDulcesNavidad.add("Hojaldres de Torrelavega");
    }
    public static DulcesNavidad[] generarDulcesNavidad(int n) {
        DulcesNavidad[] dulcesNavidad = new DulcesNavidad[n];
        for (int i = 0; i < n; i++) {
            dulcesNavidad[i] = DulcesNavidad.generarDulceNavidad();
        }
        return dulcesNavidad;
    }
}
