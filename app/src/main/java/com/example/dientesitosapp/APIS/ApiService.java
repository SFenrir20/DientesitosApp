package com.example.dientesitosapp.APIS;

import com.example.dientesitosapp.Models.LoginRequest;
import com.example.dientesitosapp.Models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
      @POST("Login")
    Call<LoginResponse>LOGIN_RESPONSE_CALL(@Body LoginRequest request);
}
