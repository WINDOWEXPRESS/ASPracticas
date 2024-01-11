package com.example.aspracticas.ut06.ejemplos.partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aspracticas.R;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;

public class Lista extends AppCompatActivity {

    RecyclerView reyclerViewUser;
    Button add;
    PartidoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u6_ejemplos_lista);

        reyclerViewUser = findViewById(R.id.u6_ejemplos_recyclerView_resultados);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new PartidoAdapter(Partido.generatePartidos(Partido.PARTIDOS_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.u6_ejemplos_bt_aniadir);
        add.setOnClickListener(view -> adapter.add(Partido.generatePartidos(Partido.PARTIDOS_INICIALES)));

        //adapter.notifyDataSetChanged();
    }
}