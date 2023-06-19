package com.example.dientesitosapp.Conexion;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cconexion {

    private static final String URL ="http://zhanzheng-001-site1.dtempurl.com/api/";
    private static Retrofit retrofit = null;

   public static Retrofit getRetrofit() {
       if (retrofit == null) {
           retrofit = new Retrofit.Builder()
                   .baseUrl(URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return retrofit;
   }
}
