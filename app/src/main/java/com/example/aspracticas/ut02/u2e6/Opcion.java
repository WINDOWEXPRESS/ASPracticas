package com.example.aspracticas.ut02.u2e6;

import com.example.aspracticas.R;

public enum Opcion {
    PIEDRA( R.string.u2a6_piedra),PAPEL(R.string.u2a6_papel), TIJERA( R.string.u2a6_tijera);

    //Para no tener problema el texto al cambiar el idioma
    public final int referenciaStringsXML;
    Opcion(int referenciaStringXML) {
        this.referenciaStringsXML = referenciaStringXML;
    }

}
