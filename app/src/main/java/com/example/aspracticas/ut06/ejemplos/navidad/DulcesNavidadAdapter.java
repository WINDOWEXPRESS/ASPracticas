package com.example.aspracticas.ut06.ejemplos.navidad;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aspracticas.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DulcesNavidadAdapter} factory method to
 * create an instance of this fragment.
 */
public class DulcesNavidadAdapter extends RecyclerView.Adapter<DulcesNavidadAdapter.ViewHolder> {

    private final List<DulcesNavidad> DulcesNavidad;

    public DulcesNavidadAdapter(List<DulcesNavidad> dulces) {
        DulcesNavidad = dulces;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.u6e_fragment_dulces_navidad_adapter, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final DulcesNavidadAdapter.ViewHolder holder, int position) {
        holder.getNombreDulce().setText(DulcesNavidad.get(position).getNombre());
        holder.getFrutoSeco().setText((DulcesNavidad.get(position).isFrutoSeco()?" si ": " no "));
        holder.getCaloria().setText(DulcesNavidad.get(position).getCaloria()+"kJ");

    }

    @Override
    public int getItemCount() {
        return DulcesNavidad.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreDulce;
        private final TextView frutoSeco;
        private final TextView caloria;

        public ViewHolder(View binding) {
            super(binding);
            nombreDulce = binding.findViewById(R.id.u6e_navidad_nombreDulce);
            frutoSeco = binding.findViewById(R.id.u6e_navidad_frutoSeco);
            caloria = binding.findViewById(R.id.u6e_navidad_caloria);
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