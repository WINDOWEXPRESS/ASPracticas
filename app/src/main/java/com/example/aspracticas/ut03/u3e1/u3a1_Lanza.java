package com.example.aspracticas.ut03.u3e1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.aspracticas.R;

public class u3a1_Lanza extends AppCompatActivity {
    public static final String INFO_NOMBRE = "CLAVE_NOMBRE";
    Button boton;
    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1_lanza);

        boton = findViewById(R.id.u3a1_bt_click);
        etNombre = findViewById(R.id.u3a1_eText_nombre);

        boton.setOnClickListener(view -> {
            Intent i = new Intent(this, u3a1_Lanzada.class);
            //i.putExtra(INFO_NOMBRE, etNombre.getText().toString());
            i.putExtra(INFO_NOMBRE, etNombre.getText().toString());
            startActivity(i);
        });


    }
}