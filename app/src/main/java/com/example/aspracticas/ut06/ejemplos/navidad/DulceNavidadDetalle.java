package com.example.aspracticas.ut06.ejemplos.navidad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.aspracticas.R;
import com.example.aspracticas.databinding.U6eDulceNavidadDetalleBinding;

public class DulceNavidadDetalle extends AppCompatActivity {
    private DulcesNavidad dulceNavidad;
    U6eDulceNavidadDetalleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.u6e_dulce_navidad_detalle);

        binding = U6eDulceNavidadDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dulceNavidad = (DulcesNavidad) getIntent().getSerializableExtra("ARTICLE_ID");
        binding.u6eTextVDetalleNombre.setText(dulceNavidad.getNombre());
        binding.u6eTextVDetalleFrutoSeco.setText(dulceNavidad.isFrutoSeco()?" si ": " no ");
        binding.u6eTextVDetalleCaloria.setText(dulceNavidad.getCaloria()+"kJ");

    }
}