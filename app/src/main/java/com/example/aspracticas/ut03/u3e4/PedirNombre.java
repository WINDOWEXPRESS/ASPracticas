package com.example.aspracticas.ut03.u3e4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.aspracticas.R;

public class PedirNombre extends AppCompatActivity {
    public static final String CLAVE_NOMBRE = "asd";
    EditText nombre;
    Button aceptar,cancelar,limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4_pedir_nombre);
        nombre = findViewById(R.id.u3a4_eText_nombre);
        aceptar = findViewById(R.id.u3a4_bt_Confirmar);
        cancelar = findViewById(R.id.u3a4_bt_cancelar);
        limpiar = findViewById(R.id.u3a4_bt_limpiar);

        aceptar.setOnClickListener(v -> {
            if(!nombre.getText().toString().isEmpty()){
                Intent data = new Intent();
                data.putExtra(CLAVE_NOMBRE, nombre.getText().toString());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
        cancelar.setOnClickListener(view->{
            setResult(Activity.RESULT_CANCELED);
            finish();
        });
        limpiar.setOnClickListener(v -> {
            setResult(Activity.RESULT_FIRST_USER);
            finish();
        });
    }
}