package com.example.aspracticas.ut9.plantillaexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aspracticas.R;

public class Principal extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PeliculasRecyclerViewAdapter recyclerViewAdapter;
    private ProgressBar progressBar;
    private Button botonCargar;
    private Button botonAniadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u9plantillae_activity_principal);

        vincularVistas();

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));


        PeliculaViewModel peliculaViewModel = new ViewModelProvider(this).get(PeliculaViewModel.class);
        peliculaViewModel.getPeliculaPojoMutableLiveData().observe(this,peliculaPojos -> {
            // Actualizar el adaptador del RecyclerView con los nuevos datos
            recyclerViewAdapter= new PeliculasRecyclerViewAdapter(peliculaPojos);
            recyclerView.setAdapter(recyclerViewAdapter);
        });
        peliculaViewModel.getLoadingLiveData().observe(this,loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        peliculaViewModel.getErrorLiveData().observe(this, errorMessage -> {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        });

        //Este metodo sirve para obtener mas datos por api pero claro si el endpoint admine parametro y
        //la paginación o la limitación de resultados.
        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItemCount = layoutManager.getItemCount();
                int lastVisibleItem = layoutManager.findLastVisibleItemPosition();

                if (lastVisibleItem == totalItemCount - 1) {
                    // Se ha alcanzado el final de la lista, cargar más datos
                    //peliculaViewModel.cargarDatosDesdeApi();
                }
            }
        });*/

        botonCargar.setOnClickListener(v -> {
            peliculaViewModel.cargarDatosDesdeApi();
        });
        botonAniadir.setOnClickListener(v -> {
            Intent intent = new Intent(this,AniadiPelicula.class);
            startActivity(intent);
        });

    }

    private void vincularVistas() {
        recyclerView = findViewById(R.id.u9pE_activityP_recyclerV_lista);
        progressBar = findViewById(R.id.u9pE_activityP_progressB_cargar);
        botonCargar = findViewById(R.id.u9pE_activityP_button_cargarDatos);
        botonAniadir = findViewById(R.id.u9pE_activityP_button_aniadir);
    }
}