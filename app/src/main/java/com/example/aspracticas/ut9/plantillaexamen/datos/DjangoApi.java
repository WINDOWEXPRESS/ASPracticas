package com.example.aspracticas.ut9.plantillaexamen.datos;

import com.example.aspracticas.ut9.ejemplos.pokeapi.datos.PojoPokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DjangoApi {
    @GET("peliculas_related/")
    Call<List<PeliculaPojo>> getPeliculas();

    @POST("peliculas_related/")
    Call<PeliculaPojo> subirPeliculas(@Body PeliculaPojo peliculaPojo);

}
