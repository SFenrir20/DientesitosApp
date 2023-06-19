package com.example.dientesitosapp.APIS;

import com.example.dientesitosapp.Models.Paciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("paciente")
    Call<List<Paciente>> getPaciente();
}
