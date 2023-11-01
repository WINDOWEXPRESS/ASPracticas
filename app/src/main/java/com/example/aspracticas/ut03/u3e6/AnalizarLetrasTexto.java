package com.example.aspracticas.ut03.u3e6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aspracticas.R;

public class AnalizarLetrasTexto extends AppCompatActivity {

    public static final String CLAVE_TEXTO = "DSADdsadasss";
    TextView textoRecibido, mostrarInfo;
    Button btAnalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_analizar_letras_texto);

        textoRecibido = findViewById(R.id.u3a6_eTextML_texto);
        mostrarInfo = findViewById(R.id.u3a6_tView_Resultado);
        btAnalizar = findViewById(R.id.u3a6_bt_analizar);

        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result) -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        textoRecibido.setText("");

                        Bundle data;
                        if (result.getData() != null) {
                            data = result.getData().getExtras();
                            StringBuilder listado = new StringBuilder();
                            listado.append(data.getChar(AnalizadorLetras.CLAVE_CARACTER_UNO)).append(" : ");
                            listado.append(data.getInt(AnalizadorLetras.CLAVE_NUMERO_UNO)).append("\n");
                            listado.append(data.getChar(AnalizadorLetras.CLAVE_CARACTER_DOS)).append(" : ");
                            listado.append(data.getInt(AnalizadorLetras.CLAVE_NUMERO_DOS)).append("\n");
                            listado.append(data.getChar(AnalizadorLetras.CLAVE_CARACTER_TRES)).append(" : ");
                            listado.append(data.getInt(AnalizadorLetras.CLAVE_NUMERO_TRES)).append("\n");
                            mostrarInfo.setText(listado);
                        }
                    }
                });

        textoRecibido.setOnClickListener(v -> {
            if(mostrarInfo.getText().length() != 0){
                mostrarInfo.setText(null);
            }
        });

        btAnalizar.setOnClickListener(v -> {
            if (textoRecibido.getText().length() != 0) {
                Intent datos = new Intent(this, AnalizadorLetras.class);
                datos.putExtra(CLAVE_TEXTO, textoRecibido.getText().toString());

                lanzador.launch(datos);
            }
        });

    }
}