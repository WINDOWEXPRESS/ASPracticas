package com.example.aspracticas.ut03.u3e5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aspracticas.R;

public class SiguienteNumero extends AppCompatActivity {

    public static final String CLAVE_VALOR = "DASDdadadasDAS";

    TextView tvNumeroSiguienteFibo;
    Button confirmar;

    int valorSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a5_siguiente_numero);

        tvNumeroSiguienteFibo = findViewById(R.id.u3a5_tView_numeroSiguiente);
        confirmar = findViewById(R.id.u3a5_bt_confirmar);

        Bundle manipuladorDato = getIntent().getExtras();

        valorSiguiente = (int) manipuladorDato.get(Fibonacci.CLAVE_PRIMER_VALOR);
        valorSiguiente += (int) manipuladorDato.get(Fibonacci.CLAVE_SEGUNDO_VALOR);

        tvNumeroSiguienteFibo.setText(""+valorSiguiente);

        confirmar.setOnClickListener(view -> {
            Intent datos = new Intent();
            datos.putExtra(CLAVE_VALOR,valorSiguiente);
            setResult(Activity.RESULT_OK, datos);
            finish();
        });

    }
}