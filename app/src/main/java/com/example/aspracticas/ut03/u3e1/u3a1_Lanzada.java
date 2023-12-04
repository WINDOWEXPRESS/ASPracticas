package com.example.aspracticas.ut03.u3e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.aspracticas.R;

public class u3a1_Lanzada extends AppCompatActivity {
    TextView mostrar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1_lanzada);

        mostrar = findViewById(R.id.u3a1_tView_Hola);

        Bundle info = getIntent().getExtras();

        String nombre = info.getString(u3a1_Lanza.INFO_NOMBRE);

        mostrar.setText(nombre);
    }
}