package com.example.aspracticas.ut02.u2e3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.aspracticas.R;

import java.util.Objects;

public class Propinatron2000 extends AppCompatActivity {
    //declarar las variables
    Button uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero;
    Button limpiar,borrar,calcular;
    TextView dineroSinPropina, tViewDineroFinal;
    RadioGroup experiencia ;
    View.OnClickListener manejadorNumero;
    String dineroString = "";
    int dineroFinal = 0;
    //uno es cuando no hay propina
    int porcentajePropina = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propinatron2000);

        //vincular con los componentes
        uno = findViewById(R.id.u2a3btUno);
        dos = findViewById(R.id.u2a3btDos);
        tres = findViewById(R.id.u2a3btTres);
        cuatro = findViewById(R.id.u2a3btCuatro);
        cinco = findViewById(R.id.u2a3btCinco);
        seis = findViewById(R.id.u2a3btSeis);
        siete = findViewById(R.id.u2a3btSiete);
        ocho = findViewById(R.id.u2a3btOcho);
        nueve = findViewById(R.id.u2a3btNueve);
        cero = findViewById(R.id.u2a3btCero);

        limpiar = findViewById(R.id.u2a3btLimpiar);
        borrar = findViewById(R.id.u2a3btBorrar);
        calcular = findViewById(R.id.u2a3btCalcular);
        dineroSinPropina = findViewById(R.id.u2a3tVDineroSinPropina);
        tViewDineroFinal = findViewById(R.id.u2a3tViewPrecioFinal);

        experiencia = findViewById(R.id.rGroupExperiencia);

        //inplementar la interfaz de view setOnClickListener
        manejadorNumero = ((View view)-> {
            //casting de la clase view a button
            Button boton = (Button) view;
            dineroString += boton.getText().toString();
            dineroSinPropina.setText(dineroString);
        })
        ;

        uno.setOnClickListener(manejadorNumero);
        dos.setOnClickListener(manejadorNumero);
        tres.setOnClickListener(manejadorNumero);
        cuatro.setOnClickListener(manejadorNumero);
        cinco.setOnClickListener(manejadorNumero);
        seis.setOnClickListener(manejadorNumero);
        siete.setOnClickListener(manejadorNumero);
        ocho.setOnClickListener(manejadorNumero);
        nueve.setOnClickListener(manejadorNumero);
        cero.setOnClickListener(manejadorNumero);

        borrar.setOnClickListener(view -> {
            if (dineroString.length()>0){
                //borrar el ultimo posicion
                dineroString = dineroString.substring(0, dineroString.length()-1);
                dineroSinPropina.setText(dineroString);
            }
        });
        limpiar.setOnClickListener(view -> {
            dineroSinPropina.setText("");
            dineroString = "";
        });

        experiencia.setOnCheckedChangeListener((radioGroup, i) -> {
            //-1 : cuando no hay opcion elegido
            if(i != -1){
                if (i == R.id.u2a3rButtonMal) {
                    porcentajePropina = 5;
                } else if (i == R.id.u2a3rButtonBien) {
                    porcentajePropina = 10;
                }else {
                    porcentajePropina = 15;
                }
            }
        });

        calcular.setOnClickListener(view -> {
            if(!Objects.equals(dineroString, "")){
                int dinero = Integer.parseInt(dineroString);
                dineroFinal = dinero+(dinero*porcentajePropina/100);
                tViewDineroFinal.setText(String.format("%d", dineroFinal));
            }
        });
    }
}