package com.example.aspracticas.ut03.u3e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.aspracticas.R;

public class u3a1_Lanza extends AppCompatActivity {
    Button boton;
    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1_lanza);

        boton = findViewById(R.id.u3a1_bt_click);



    }
}