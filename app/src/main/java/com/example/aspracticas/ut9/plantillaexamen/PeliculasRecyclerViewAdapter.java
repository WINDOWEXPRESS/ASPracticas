package com.example.aspracticas.ut9.plantillaexamen;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspracticas.ut9.plantillaexamen.datos.PeliculaPojo;
import com.example.aspracticas.databinding.FragmentPeliculasBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PeliculaPojo}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PeliculasRecyclerViewAdapter extends RecyclerView.Adapter<PeliculasRecyclerViewAdapter.ViewHolder> {

    public static final String INTENT_PELICULA_KEY = "peliculaSeleccionada";
    private final List<PeliculaPojo> peli;

    public PeliculasRecyclerViewAdapter(List<PeliculaPojo> peliculaPojoList) {
        peli = peliculaPojoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate layout for RecyclerView item
        return new ViewHolder(FragmentPeliculasBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // Aqui puede obtener mas detalle de cada lista
        PeliculaPojo peliculaSeleccionada = peli.get(holder.getAdapterPosition());
        holder.itemView.setOnClickListener(v -> {
            // Realiza la acción correspondiente al hacer clic en el elemento
            // Por ejemplo, muestra más detalles o inicia otra actividad
            // Iniciar una nueva actividad para mostrar más detalles sobre la película seleccionada
            Intent intent = new Intent(holder.itemView.getContext(), DetallePelicula.class);
            intent.putExtra(INTENT_PELICULA_KEY, peliculaSeleccionada);
            holder.itemView.getContext().startActivity(intent);
            //Toast.makeText(holder.itemView.getContext(),"Soy toast",Toast.LENGTH_LONG).show();
        });
        // Bind data to views in RecyclerView item
        holder.nombre.setText(peli.get(position).getNombre());
        holder.descripcion.setText(peli.get(position).getDescripcion());
        holder.estrellas.setText(peli.get(position).getEstrellas());
    }

    @Override
    public int getItemCount() {
        return peli.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nombre;
        public final TextView descripcion;
        public final TextView estrellas;

        public ViewHolder(FragmentPeliculasBinding binding) {
            super(binding.getRoot());
            nombre = binding.u9peTextVNombre;
            estrellas = binding.u9peTextVEstrellas;
            descripcion = binding.u9peTextVDescripcion;
        }

    }
}