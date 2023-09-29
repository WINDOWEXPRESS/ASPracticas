package com.example.aspracticas.u2e2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.aspracticas.R;

public class u2a2Coloneitor extends AppCompatActivity {
    EditText nombreColor;
    TextView salida;
    TextView rojo;
    TextView azul;
    TextView verde;
    SeekBar sBRojo;
    SeekBar sBAzul;
    SeekBar sBVerde;
    Button mostrar;
    Switch textoBlanco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a2_coloneitor);

        //Vincular las variables con los elementos
        nombreColor = findViewById(R.id.u2a2eTNombreColor);
        salida = findViewById(R.id.u2a2tVSalida);
        mostrar = findViewById(R.id.u2a2btMostrar);
        textoBlanco = findViewById(R.id.u2a2sTextoBlanco);
        rojo = findViewById(R.id.u2a2tVRojo);
        azul = findViewById(R.id.u2a2tVAzul);
        verde = findViewById(R.id.u2a2tVVerde);
        sBRojo = findViewById(R.id.u2a2sBRojo);
        sBAzul = findViewById(R.id.u2a2sBAzul);
        sBVerde = findViewById(R.id.u2a2sBVerde);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rangoRojo = sBRojo.getProgress();
                salida.setBackgroundColor(sBRojo,sBAzul,sBVerde);

            }
        });

    }
}