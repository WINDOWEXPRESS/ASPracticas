package com.example.aspracticas.ut8.ejemplos.numeroaleatorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aspracticas.R;

public class NumeroAleatorio extends AppCompatActivity {

    TextView tvNumero;
    Button btGenerar;
    ProgressBar pbCargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u8e_activity_numero_aleatorio);

        tvNumero = findViewById(R.id.u8e_textV_numero);
        btGenerar = findViewById(R.id.u8e_button_generar);
        pbCargando = findViewById(R.id.u8e_progressB_cargar);

        NumeroAleatorioViewModel vm = new ViewModelProvider(this).get(NumeroAleatorioViewModel.class);

        vm.getNumero().observe(this, integer -> {
            // Actualizar la interfaz
            if(integer == NumeroAleatorioViewModel.FAIL){
                tvNumero.setText("Error en el acceso a los datos");
            }else{
                tvNumero.setText(""+integer);
            }

            pbCargando.setVisibility(View.INVISIBLE);
            tvNumero.setVisibility(View.VISIBLE);
            btGenerar.setEnabled(true);
        });
        btGenerar.setEnabled(false);

        btGenerar.setOnClickListener((v)->{

            pbCargando.setVisibility(View.VISIBLE);
            tvNumero.setVisibility(View.INVISIBLE);
            btGenerar.setEnabled(false);
            vm.cargaNumero();
        });
    }
}