package com.example.aspracticas.ut03.u3e8;

import java.io.Serializable;

public class Monstruo implements Serializable {
    /*
    Crea una clase monstruo que tendrá un nombre, un número de miembros (Manos y piernas) y un color.
    En el constructor se establece toda la información. Cuando se llame al toString pintará un monstruo con assciart.
    La distribución de los miembros entre manos y piernas es aleatoria y se establece en el constructor.
*/
    private String nombre;
    private int numeroMiembros;
    private int numeroManoDerecha;
    private int numeroManoIzquierda;
    private int numeroPiernaDerecha;
    private int numeroPiernaIzquierda;
    private String color;


    public Monstruo(String nombre, int numeroMiembros, String color) {
        this.nombre = nombre;
        this.numeroMiembros = numeroMiembros;
        this.color = color;

        this.numeroManoDerecha = (int) (Math.random()*numeroMiembros);
        numeroMiembros -= numeroManoDerecha;
        this.numeroManoIzquierda = (int) (Math.random()*numeroMiembros);
        numeroMiembros -= numeroManoIzquierda;
        numeroPiernaDerecha = (int) (Math.random()*numeroMiembros);
        numeroMiembros -= numeroPiernaDerecha;
        this.numeroPiernaIzquierda = numeroMiembros;
    }

    public String getColor() {
        return color;
    }

    // Método auxiliar para repetir un carácter n veces
    private String repetirCaracter(char caracter, int veces) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            resultado.append(caracter);
        }
        return resultado.toString();
    }


    @Override
    public String toString() {
        StringBuilder monstruoAscii = new StringBuilder();
        /*
        monstruoAscii.append("Nombre: ").append(nombre).append("\n");
        monstruoAscii.append("Color: ").append(color).append("\n");
        monstruoAscii.append("Miembros: ").append(numeroMiembros).append("\n");
        */
        monstruoAscii.append(repetirCaracter(' ', numeroManoIzquierda)).append(" * ").append("\n");
        monstruoAscii.append(repetirCaracter('/', numeroManoIzquierda)).append(" O ").append(repetirCaracter('\\', numeroManoDerecha)).append("\n");
        monstruoAscii.append(repetirCaracter('/', numeroPiernaIzquierda)).append("    ").append(repetirCaracter('\\', numeroPiernaDerecha));
        return monstruoAscii.toString();
    }
}
