package com.example.aspracticas.ut9.ejemplos.pokeapi.datos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {
    @GET("pokemon/{nombre}")
    Call<PojoPokemon> getCharacter(@Path("nombre") String nombre);
}
