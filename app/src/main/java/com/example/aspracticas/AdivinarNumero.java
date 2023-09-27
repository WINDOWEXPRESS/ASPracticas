package com.example.aspracticas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdivinarNumero extends AppCompatActivity {

    //Declarar las variables
    TextView resultado;
    Button btReinicar;
    Button btConfirmar;
    EditText eTNumero;
    int bomba;
    int valorMinimo = 0;
    int valorMaximo = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivinar_numero);

        //vincular las variables con los botones
        resultado = findViewById(R.id.tvResultado);
        btReinicar = findViewById(R.id.btReiniciar);
        btConfirmar = findViewById(R.id.btConfirmar);
        eTNumero = findViewById(R.id.eTNumero);

        //Generar un numero aleatorio
        bomba = (int) (Math.random()*100);

        //Reiniciar el juego
        btReinicar.setOnClickListener((View view)->{
            bomba = (int) (Math.random()*100);
            valorMinimo = 0;
            valorMaximo = 100;
            resultado.setText(valorMinimo+ " - " +valorMaximo);
        });

        //Confirmar si acierta
        btConfirmar.setOnClickListener((View view)->{
            String numeroText = eTNumero.getText().toString();
            int numeroIntroducir = -1;

            try {
                numeroIntroducir = Integer.parseInt(numeroText);
            }catch (Exception e){
                resultado.setText("Formato no numerico");
            }

            //imprimir msg si o no acierta el numero
            if(numeroIntroducir == bomba){
                resultado.setText(R.string.tVPisaBomba);
            }else{
                if (numeroIntroducir < bomba && numeroIntroducir > valorMinimo) {
                    valorMinimo = numeroIntroducir;
                }else if (numeroIntroducir > bomba && numeroIntroducir <= valorMaximo) {
                    valorMaximo = numeroIntroducir;
                }
                resultado.setText(valorMinimo+ " - " +valorMaximo);
            }
        });


    }
}