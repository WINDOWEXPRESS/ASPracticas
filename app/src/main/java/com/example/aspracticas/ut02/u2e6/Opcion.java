package com.example.aspracticas.ut02.u2e6;

import com.example.aspracticas.R;

public enum Opcion {
    PIEDRA(1, R.string.u2a6_piedra),PAPEL(2,R.string.u2a6_papel), TIJERA(3, R.string.u2a6_tijera);

    public final int valorNumerico;
    public final int referenciaStringsXML;
    Opcion(int valorNumerico, int referenciaStringXML) {
        this.valorNumerico = valorNumerico;
        this.referenciaStringsXML = referenciaStringXML;
    }

}
