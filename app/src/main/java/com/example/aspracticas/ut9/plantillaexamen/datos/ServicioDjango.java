package com.example.aspracticas.ut9.plantillaexamen.datos;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioDjango {
    private static ServicioDjango instacia;
    private static DjangoApi repositorio;

    private ServicioDjango(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.111:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        repositorio = retrofit.create(DjangoApi.class);
    }
    public  static ServicioDjango getInstance(){
        if(instacia == null){
            instacia = new ServicioDjango();
        }
        return instacia;
    }

    public DjangoApi getRepor(){
        if(repositorio == null){
            return null;
        }else{
            return repositorio;
        }
    }
}
