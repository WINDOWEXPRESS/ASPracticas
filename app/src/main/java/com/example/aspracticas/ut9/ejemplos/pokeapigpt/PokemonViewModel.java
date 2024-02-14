package com.example.aspracticas.ut9.ejemplos.pokeapigpt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aspracticas.ut9.ejemplos.pokeapi.datos.PedicionPokemon;
import com.example.aspracticas.ut9.ejemplos.pokeapi.datos.PojoPokemon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonViewModel extends ViewModel {
    private MutableLiveData<PojoPokemon> pokemonLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public LiveData<PojoPokemon> getPokemonLiveData() {
        return pokemonLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
    public void buscarPokemon(String nombre) {
        loadingLiveData.setValue(true);
        PedicionPokemon pedicion = PedicionPokemon.getInstancia();
        Call<PojoPokemon> llamada = pedicion.getPokemonApi().getCharacter(nombre);
        llamada.enqueue(new Callback<PojoPokemon>() {
            @Override
            public void onResponse(Call<PojoPokemon> call, Response<PojoPokemon> response) {
                loadingLiveData.setValue(false);
                if (response.isSuccessful()) {
                    pokemonLiveData.setValue(response.body());
                } else {
                    errorLiveData.setValue("Pokemon no encontrado o no existe.");
                }
            }

            @Override
            public void onFailure(Call<PojoPokemon> call, Throwable t) {
                loadingLiveData.setValue(false);
                errorLiveData.setValue("Error al buscar el Pokemon.");
            }
        });
    }
}
