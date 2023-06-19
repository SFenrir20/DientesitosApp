package com.example.dientesitosapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dientesitosapp.APIS.ApiService;
import com.example.dientesitosapp.Conexion.Cconexion;
import com.example.dientesitosapp.R;

import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

      private  Button btnLogin;
      private   EditText edUser, edPass;

      private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         btnLogin = findViewById(R.id.btn_Iniciar);
         edUser = findViewById(R.id.txtUsuario);
         edPass = findViewById(R.id.txtPass);

         //Crear instancia de api Service utilixando retrofit
        apiService = Cconexion.getRetrofit().create(ApiService.class);

        //manejar el evento de inicio de sesion el boton

         btnLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //
             }
         });

    }
}