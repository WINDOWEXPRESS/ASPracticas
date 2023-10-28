package com.example.aspracticas.ut03.u3e4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aspracticas.R;

public class MostrarNombre extends AppCompatActivity {
    TextView nombre;
    Button pedirNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4_mostrar_nombre);

        nombre = findViewById(R.id.u3a4_tView_Nombre);
        pedirNombre = findViewById(R.id.u3a4_bt_pedirNombre);

        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Bundle data = result.getData().getExtras();
                        nombre.setText(data.getString(PedirNombre.CLAVE_NOMBRE));
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        nombre.setText("El usuario ha cancelado la operación");
                    } else if (result.getResultCode() == Activity.RESULT_FIRST_USER){
                        nombre.setText("El usuario quiere limpiar el nombre anterior");
                    }
                }
        );


        pedirNombre.setOnClickListener(v -> {
            Intent intent = new Intent(this, PedirNombre.class);
            //Lanza atraves de ActivityResultLauncher
            lanzadora.launch(intent);
        });
    }
}