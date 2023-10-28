package com.example.aspracticas.ut03.u3e3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;

import com.example.aspracticas.R;

public class MostrarHelado extends AppCompatActivity {
    TextView recipiente, tViewConos;
    Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a3_mostrar_helado);

        recipiente = findViewById(R.id.u3a3_tView_recipiente);
        tViewConos = findViewById(R.id.u3a3_tView_conos);
        finalizar = findViewById(R.id.u3a3_bt_finalizar);
        //Instanciar Bundle
        Bundle info = getIntent().getExtras();
        //Obtener datos de intent
        int cantidadVainilla = info.getInt(Heladotron.CLAVE_CANTIDAD_VAINILLA);
        int cantidadChoco = info.getInt(Heladotron.CLAVE_CANTIDAD_CHOCO);
        int cantidadFresa = info.getInt(Heladotron.CLAVE_CANTIDAD_FRESA);
        int cantidadTotal = cantidadVainilla + cantidadChoco + cantidadFresa;

        String recipienteSeleccionada = info.getString(Heladotron.CLAVE_RECIPIENTE);

        //Configurar text de recipiente
        if (recipienteSeleccionada.equals("Tarina")) {
            recipiente.setText("U");
        } else if (recipienteSeleccionada.equals("Cucurucho")) {
            recipiente.setText("V");
            //Poner color referente al recipiente
            int colorCucurucho = ContextCompat.getColor(this, R.color.colorMarronClaro);
            recipiente.setTextColor(colorCucurucho);
        } else {
            recipiente.setText("V");
            //Poner color referente al recipiente
            int colorCucuruchoCocho = ContextCompat.getColor(this, R.color.colorMarronOscuro);
            recipiente.setTextColor(colorCucuruchoCocho);
        }
        // //Poner color referente al Cono
        int colorVainilla = ContextCompat.getColor(this, R.color.colorVainilla);
        int colorChocolate = ContextCompat.getColor(this, R.color.colorChocolate);
        int colorFresa = ContextCompat.getColor(this, R.color.colorFresa);

        String conos = dibujarConos(cantidadTotal);

        // Crear una instancia de SpannableString
        SpannableString configurarColorTView = new SpannableString(conos);

        // Aplicar estilo de color a los caracteres desde el índice 0 hasta el cantidad Vainilla
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(colorVainilla);
        configurarColorTView.setSpan(colorSpan, 0, cantidadVainilla, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Aplicar estilo de color a los caracteres desde el índice cantidad Vainilla hasta el cantidad Choco
         colorSpan = new ForegroundColorSpan(colorChocolate);
        configurarColorTView.setSpan(colorSpan, cantidadVainilla, cantidadVainilla+cantidadChoco, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        // Aplicar estilo de color a los caracteres desde el índice cantidad Choco hasta el cantidad Fresa
         colorSpan = new ForegroundColorSpan(colorFresa);
        configurarColorTView.setSpan(colorSpan, cantidadVainilla+cantidadChoco, cantidadVainilla+cantidadChoco+cantidadFresa, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


        // Establecer el texto formateado en el TextView
        tViewConos.setText(configurarColorTView);

        finalizar.setOnClickListener(v -> finish());
    }

    private String dibujarConos(int cantidad) {
        int capacidad = 1024;
        StringBuilder conos = new StringBuilder(capacidad);
        for (int i = 0; i < cantidad; i++) {
            conos.append("O");
        }
        return conos.toString();
    }
}