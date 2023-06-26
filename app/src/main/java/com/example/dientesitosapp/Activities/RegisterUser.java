package com.example.dientesitosapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dientesitosapp.APIS.ApiService;
import com.example.dientesitosapp.Conexion.Cconexion;
import com.example.dientesitosapp.Models.Paciente;
import com.example.dientesitosapp.Models.Sede;
import com.example.dientesitosapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUser extends AppCompatActivity {
    private Button _btnGrabar;
    private Spinner _spSede,_spTratamiento,_spDoctor;
    private EditText _edtDate,_edtHour;
    private ApiService apiService;
    private List<Sede> sedes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        _btnGrabar = (Button) findViewById(R.id.btnGrabar);
        _spSede = (Spinner) findViewById(R.id.spinnerSede);
        _spTratamiento=(Spinner) findViewById(R.id.spinnerTratamiento);
        _spDoctor =(Spinner) findViewById(R.id.spinnerDoctor);
        _edtDate=(EditText) findViewById(R.id.edtDate);
        _edtHour=(EditText) findViewById(R.id.edtTime);

        apiService = Cconexion.getRetrofit().create(ApiService.class);
        SpinnerSede();
    }
    public void SpinnerSede()
    {
        Call<List<Sede>> call= apiService.getSede();
        call.enqueue(new Callback<List<Sede>>() {
            @Override
            public void onResponse(Call<List<Sede>> call, Response<List<Sede>> response) {
                if(response.isSuccessful())
                {
                    sedes = response.body();
                    String[] items = new String[sedes.size()];
                    for(int i=0; i< sedes.size(); i++)
                    {
                        /*if(i==0)
                        {
                            items[i] = sedes.setDireccion("sede");
                        }*/
                        items[i] = sedes.get(i).getDireccion();
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterUser.this, android.R.layout.simple_list_item_1, items);
                    _spSede.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Sede>> call, Throwable t) {
                AlertDialog.Builder error = new AlertDialog.Builder(RegisterUser.this);
                error.setMessage("No hay sede");
                error.show();
                t.printStackTrace();

            }
        });
    }
    /*public void SpinnerHorario()
    {
        ServiceAPI serviceAPI = ConnectionREST.getConnection().create(ServiceAPI.class);
        Call<List<Horario>> call = serviceAPI.listhorario();
        call.enqueue(new Callback<List<Horario>>() {
            @Override
            public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
                if(response.isSuccessful())
                {
                    listhorario = response.body();
                    String[] items = new String[listhorario.size()];
                    for(int i=0; i< listhorario.size(); i++)
                    {
                        items[i] = listhorario.get(i).getFechaI() + " - " + listhorario.get(i).getFechaF(); ;
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(registrar_cita.this, android.R.layout.simple_list_item_1, items);
                    sHorario.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {

            }});*/
}