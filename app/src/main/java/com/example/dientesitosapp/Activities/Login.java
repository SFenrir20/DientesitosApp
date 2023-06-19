package com.example.dientesitosapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dientesitosapp.APIS.ApiService;
import com.example.dientesitosapp.Conexion.Cconexion;
import com.example.dientesitosapp.Models.Paciente;
import com.example.dientesitosapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class Login extends AppCompatActivity {

      private  Button btnLogin;
      private   EditText edUser, edPass;

      private ApiService apiService;
      private List<Paciente> pacientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         btnLogin = findViewById(R.id.btn_Iniciar);
         edUser = findViewById(R.id.txtUsuario);
         edPass = findViewById(R.id.edPasword);
         //Crear instancia de api Service utilixando retrofit
        apiService = Cconexion.getRetrofit().create(ApiService.class);

        //manejar el evento de inicio de sesion el boton
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usermane = edUser.getText().toString();
                String password = edPass.getText().toString();
                for (Paciente paciente :pacientes){
                    if(paciente.getDocumento().equals(usermane) && paciente.getContrasena().equals(password)){
                        Intent intent = new Intent(Login.this,RegisterUser.class);
                        startActivity(intent);
                        break;
                    }else{
                        AlertDialog.Builder error = new AlertDialog.Builder(view.getContext());
                        error.setMessage("Erro");
                        error.show();
                    }
                }
            }
        });

        Call<List<Paciente>> call = apiService.getPaciente();
        call.enqueue(new Callback<List<Paciente>>() {
            @Override
            public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response) {
                if (response.isSuccessful()){
                    pacientes = response.body();
                }else{
                  //  Toast.makeText(null,"erro",Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<List<Paciente>> call, Throwable t) {
             //   Toast.makeText(null,"Ocurrio un Erro",Toast.LENGTH_SHORT);
            }
        });
    }
    private void showErrorDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error de inicio de sesión")
                .setMessage("El nombre de usuario o la contraseña son incorrectos.")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al hacer clic en el botón "Aceptar"
                    }
                })
                .setCancelable(false)
                .show();
    }
}