package com.example.aspracticas.ut9.ejemplos.pokeapi.datos;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PedicionPokemon {
    private static PedicionPokemon instancia;
    private static PokemonApi pokemon;

    private PedicionPokemon(){
        // Hago cosas
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemon = retrofit.create(PokemonApi.class);
    }
    public static PokemonApi getPokemonApi(){
        return pokemon;
    }

    public static PedicionPokemon getInstancia(){
        if(instancia == null){
            instancia =  new PedicionPokemon();
        }
        return instancia;
    }
}
