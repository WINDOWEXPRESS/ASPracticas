package com.example.aspracticas.ut06.ejemplos.navidad;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aspracticas.ut06.ejemplos.navidad.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.aspracticas.databinding.U6eFragmentDulcesNavidadAdapterBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class DulcesNavidadRecyclerViewAdapter extends RecyclerView.Adapter<DulcesNavidadRecyclerViewAdapter.ViewHolder> {

    private final List<DulcesNavidad> DulcesNavidad;

    public DulcesNavidadRecyclerViewAdapter(List<DulcesNavidad> dulces) {
        DulcesNavidad = dulces;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(U6eFragmentDulcesNavidadAdapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.getNombreDulce().setText(DulcesNavidad.get(position).getNombre());
        holder.frutoSeco.setText(""+DulcesNavidad.get(position).isFrutoSeco());
        holder.caloria.setText(""+DulcesNavidad.get(position).getCaloria());
    }

    @Override
    public int getItemCount() {
        return DulcesNavidad.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreDulce;
        private final TextView frutoSeco;
        private final TextView caloria;

        public ViewHolder(U6eFragmentDulcesNavidadAdapterBinding binding) {
            super(binding.getRoot());
            nombreDulce = binding.nombreDulce;
            frutoSeco = binding.frutoSeco;
            caloria = binding.caloria;
        }

        public TextView getNombreDulce() {
            return nombreDulce;
        }

        public TextView getFrutoSeco() {
            return frutoSeco;
        }

        public TextView getCaloria() {
            return caloria;
        }
    }
}