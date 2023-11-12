package com.example.aspracticas.ut03.u3e8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.aspracticas.R;

public class CrearMonstruo extends AppCompatActivity {
    public static final String CLAVE_SERIALIZABLE = "DASDASDASDq";
    EditText nombre, numeroMiebros;
    Spinner color;
    Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a8_crear_monstruo);

        nombre = findViewById(R.id.u3a8_eText_Nombre);
        color = findViewById(R.id.u3a8_spn_color);
        numeroMiebros = findViewById(R.id.u3a8_eText_Miembros);

        confirmar = findViewById(R.id.u3a8_bt_Confirmar);

        confirmar.setOnClickListener(v -> {
            if(!nombre.getText().toString().isEmpty() &&
            !numeroMiebros.getText().toString().isEmpty() && !color.getSelectedItem().toString().isEmpty()){
                Monstruo monstruo = new Monstruo(nombre.getText().toString(),
                        Integer.parseInt(numeroMiebros.getText().toString()), color.getSelectedItem().toString());
                Intent datos = new Intent(this, DibujarMonstruo.class);
                datos.putExtra(CLAVE_SERIALIZABLE, monstruo);
                startActivity(datos);
            }
        });
    }
}