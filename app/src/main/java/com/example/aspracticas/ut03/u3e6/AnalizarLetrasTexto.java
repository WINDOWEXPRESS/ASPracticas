package com.example.aspracticas.ut03.u3e6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aspracticas.R;

import java.util.LinkedHashMap;

public class AnalizarLetrasTexto extends AppCompatActivity {

    TextView textoRecibido,mostrarInfo;
    Button analizar;
    LinkedHashMap


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_analizar_letras_texto);
    }
}