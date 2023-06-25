package com.example.dientesitosapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dientesitosapp.APIS.ApiService;
import com.example.dientesitosapp.Conexion.Cconexion;
import com.example.dientesitosapp.Models.Paciente;
import com.example.dientesitosapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity
{
      private Button _btnLogin;
      private EditText _edUser, _edPass;
      private ApiService apiService;
      private List<Paciente> pacientes;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _btnLogin = findViewById(R.id.btnlogin);
        _edUser = findViewById(R.id.edtUsuario);
        _edPass = findViewById(R.id.edtPasword);


        apiService = Cconexion.getRetrofit().create(ApiService.class);
        _btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                String username = _edUser.getText().toString();
                String password = _edPass.getText().toString();

                Call<List<Paciente>> call = apiService.getPaciente();
                call.enqueue(new Callback<List<Paciente>>() {
                    @Override
                    public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response)
                    {
                        boolean found = false;
                        if (response.isSuccessful())
                        {
                            pacientes = response.body();

                            for (Paciente paciente : pacientes)
                            {
                                String passwordConvert = sha256.sha256(password);

                                if (username.equalsIgnoreCase(paciente.getDocumento()) && passwordConvert.equalsIgnoreCase(paciente.getConstrasena()))
                                    {
                                        // Código para el inicio de sesión exitoso
                                        found=true;
                                        Intent intent = new Intent(Login.this, RegisterUser.class);
                                        startActivity(intent);
                                        finish();
                                        break;
                                } else {
                                    // Código para el inicio de sesión fallido
                                    AlertDialog.Builder error = new AlertDialog.Builder(Login.this);
                                    error.setMessage("Error en las credenciales");
                                    error.show();
                                }
                            }
                            if (found)
                            {
                                AlertDialog.Builder error = new AlertDialog.Builder(Login.this);
                                error.setMessage("Error");
                                error.show();
                            }
                        } else
                        {
                            AlertDialog.Builder error = new AlertDialog.Builder(Login.this);
                            error.setMessage("Error de conexión");
                            error.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Paciente>> call, Throwable t)
                    {
                        AlertDialog.Builder error = new AlertDialog.Builder(Login.this);
                        error.setMessage("Error de conexión");
                        error.show();
                        t.printStackTrace();
                    }
                });
            }
        });
    }
}