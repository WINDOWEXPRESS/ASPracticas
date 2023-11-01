package com.example.aspracticas.ut03.u3e5;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aspracticas.R;
import com.example.aspracticas.ut03.u3e4.PedirNombre;

public class Fibonacci extends AppCompatActivity {

    public static final String CLAVE_PRIMER_VALOR = "daasddAsdc";
    public static final String CLAVE_SEGUNDO_VALOR = "Adsadad";
    TextView primeroNumeroFibo,segundoNumeroFibo;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a5_fibonacci);

        primeroNumeroFibo = findViewById(R.id.u3a5_primerNumero);
        segundoNumeroFibo = findViewById(R.id.u3a5_segundoNumero);
        siguiente = findViewById(R.id.u3a5_bt_siguiente);

        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Bundle data = result.getData().getExtras();
                        primeroNumeroFibo.setText(segundoNumeroFibo.getText().toString());
                        //segundoNumeroFibo.setText(""+data.getInt(SiguienteNumero.CLAVE_VALOR));
                    }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent i = new Intent(Fibonacci.this,SiguienteNumero.class);
                i.putExtra(CLAVE_PRIMER_VALOR,Integer.parseInt(primeroNumeroFibo.getText().toString()));
                i.putExtra(CLAVE_SEGUNDO_VALOR,Integer.parseInt(segundoNumeroFibo.getText().toString()));

                lanzador.launch(i);
                */
            }
        });

    }
}