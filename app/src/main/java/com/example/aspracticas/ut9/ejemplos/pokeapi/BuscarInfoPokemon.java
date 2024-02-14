package com.example.aspracticas.ut9.ejemplos.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aspracticas.R;
import com.example.aspracticas.databinding.U9eActivityBuscarInfoPokemonBinding;
import com.example.aspracticas.ut9.ejemplos.pokeapi.datos.PedicionPokemon;
import com.example.aspracticas.ut9.ejemplos.pokeapi.datos.PojoPokemon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscarInfoPokemon extends AppCompatActivity {

    U9eActivityBuscarInfoPokemonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.u9e_activity_buscar_info_pokemon);
        binding = U9eActivityBuscarInfoPokemonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.u9eProgressBCargando.setVisibility(View.INVISIBLE);

        binding.u9eButtonBuscar.setOnClickListener(view1 -> {
            binding.u9eProgressBCargando.setVisibility(View.VISIBLE);
            binding.u9eButtonBuscar.setEnabled(false);
            PedicionPokemon pedicion = PedicionPokemon.getInstancia();

            Call<PojoPokemon> llamada = pedicion.getPokemonApi().getCharacter(binding.u9eEditTTNombre.getText().toString());
            llamada.enqueue(new Callback<PojoPokemon>() {
                @Override
                public void onResponse(Call<PojoPokemon> call, Response<PojoPokemon> response) {
                    PojoPokemon pokemon = response.body();
                    if(pokemon != null){
                        binding.u9eTextVId.setText(pokemon.getId()+"");
                        binding.u9eTextVNombre.setText(pokemon.getName());
                        binding.u9eTextVAltura.setText(pokemon.getHeight()+"");
                        binding.u9eTextVPeso.setText(pokemon.getWeight()+"");

                    }else {
                        Toast.makeText(getApplicationContext(),"Pokemon no encontrado o no existe.",Toast.LENGTH_LONG).show();
                    }
                    binding.u9eProgressBCargando.setVisibility(View.INVISIBLE);
                    binding.u9eButtonBuscar.setEnabled(true);
                }

                @Override
                public void onFailure(Call<PojoPokemon> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Pokemon no encontrado",Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}