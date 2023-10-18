package com.example.aspracticas.ut03.u3e2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.aspracticas.R;

public class VisualizadorResultado extends AppCompatActivity {
    TextView salida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        salida = findViewById(R.id.u3a2_tView_Salida);

        setContentView(R.layout.u3a2_visualizador_resultado);
        Bundle b = getIntent().getExtras();
       String t =  b.getString("numero").toString();

        salida.setText(t);
    }
}