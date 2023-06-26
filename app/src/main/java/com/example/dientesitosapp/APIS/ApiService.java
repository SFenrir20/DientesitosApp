package com.example.dientesitosapp.APIS;

import com.example.dientesitosapp.Models.Doctor;
import com.example.dientesitosapp.Models.Paciente;
import com.example.dientesitosapp.Models.Sede;
import com.example.dientesitosapp.Models.Tratamiento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("paciente")
    public abstract Call<List<Paciente>> getPaciente();
    @GET("sede")
    public abstract Call<List<Sede>> getSede();
    @GET("tratamiento")
    public abstract Call<List<Tratamiento>> getTratamiento();
    @GET("doctor")
    public abstract Call<List<Doctor>> getDoctor();
}
