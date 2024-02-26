package com.example.aspracticas.ut9.plantillaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.aspracticas.R;
import com.example.aspracticas.ut9.plantillaexamen.datos.PeliculaPojo;

public class DetallePelicula extends AppCompatActivity {
    private PeliculaPojo peli;
    private TextView nombre;
    private TextView descripcion;
    private TextView estrellas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u9plantillae_activity_detalle_pelicula);

        nombre = findViewById(R.id.u9pE_activityDP_textV_nombre);
        descripcion = findViewById(R.id.u9pE_activityDP_textV_descripcion);
        estrellas = findViewById(R.id.u9pE_activityDP_textV_estrellas);

        Bundle bundle = getIntent().getExtras();
        peli = (PeliculaPojo) bundle.getSerializable(PeliculasRecyclerViewAdapter.INTENT_PELICULA_KEY);

        nombre.setText(peli.getNombre());
        descripcion.setText(peli.getDescripcion());
        estrellas.setText(peli.getEstrellas());
    }
}