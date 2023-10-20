package com.example.aspracticas.ut03.u3e2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aspracticas.R;

public class VisualizadorResultado extends AppCompatActivity {
    TextView salida;
    Button volver;
    int numero1 = 0;
    int numero2 = 0;
    int idOperador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a2_visualizador_resultado);

        salida = findViewById(R.id.u3a2_tView_Salida);
        volver = findViewById(R.id.u3a2_bt_Volver);
        //manipulador para obtener datos de otros activity
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            // El valor asociado con la clave existe y no es nulo
            numero1 = bundle.getInt(Calculator_With_Two_Activity.CLAVE_NUMERO1);
            numero2 = bundle.getInt(Calculator_With_Two_Activity.CLAVE_NUMERO2);
            idOperador = bundle.getInt(Calculator_With_Two_Activity.CLAVE_OPERADOR);
        }
        //mostrar mensaje en la salida tras abrir la actividad y hacer operacion
        mostrarOperaciones(idOperador);

        volver.setOnClickListener(view -> finish());
    }

    private void mostrarOperaciones(int idOperador){

        String resultado = getResources().getString(R.string.u3a2_resultado).toString();

        if (idOperador == Operador.SUMA.getRId()){
            salida.setText(String.format(resultado,(double)(numero1+numero2)) );
        }
        if (idOperador == Operador.RESTA.getRId()){
            salida.setText(String.format(resultado,(double)(numero1-numero2)));
        }
        if (idOperador == Operador.DIVIDIR.getRId()){
            if(numero1 == 0 && numero2 == 0){
                salida.setText(R.string.u3a2_resultado_indefinido);
            } else if (numero2 == 0) {
                salida.setText(R.string.u3a2_no_se_puede_dividir_entre_cero);
            } else if (numero1 == 0) {
                salida.setText(String.format(resultado,0.00));
            }else {
                salida.setText(String.format(resultado,(numero1/(double)numero2)));
            }
        }
        if (idOperador == Operador.MULTIPLICAR.getRId()){
            salida.setText(String.format(resultado,(double)(numero1*numero2)));
        }
        //salida.setText(Operador.RESTA.getRId()+" "+Operador.SUMA.getRId()+" "+Operador.DIVIDIR.getRId()+" " + Operador.MULTIPLICAR.getRId()+" "+idOperador);
    }
}