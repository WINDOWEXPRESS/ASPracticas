package com.example.aspracticas.ut06.ejemplos.navidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aspracticas.R;
import com.example.aspracticas.ut06.ejemplos.partidos.Partido;
import com.example.aspracticas.ut06.ejemplos.partidos.PartidoAdapter;

import java.util.Arrays;

public class u6e_navidad_Lista extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    DulcesNavidadAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u6e_navidad_lista);

        reyclerViewUser = findViewById(R.id.u6e_rccView_lista);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        //adapter = new DulcesNavidadAdapter(Arrays.asList(DulcesNavidad.generarDulcesNavidad(20)));
        adapter = new DulcesNavidadAdapter(Arrays.asList(DulcesNavidad.generarDulcesNavidad(20)),this.getApplicationContext());

        reyclerViewUser.setAdapter(adapter);

    }
}