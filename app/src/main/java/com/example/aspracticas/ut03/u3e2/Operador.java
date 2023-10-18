package com.example.aspracticas.ut03.u3e2;

import com.example.aspracticas.R;

public enum Operador {
    SUMA(R.id.u3a2_rButton_Suma),RESTA(R.id.u3a2_rButton_Resta),MULTIPLICAR(R.id.u3a2_rButton_Multi),
    DIVIDIR(R.id.u3a2_rButton_Divi);

    private final int referencia_R_Id;
    Operador(int referencia_R_Id){
        this.referencia_R_Id = referencia_R_Id;
    }
    public int getRId() {
        return referencia_R_Id;
    }

}
