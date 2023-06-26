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
import com.example.dientesitosapp.Models.Doctor;
import com.example.dientesitosapp.Models.Paciente;
import com.example.dientesitosapp.Models.Sede;
import com.example.dientesitosapp.Models.Tratamiento;
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
    private List<Tratamiento> tratamientos;
    private List<Doctor> doctors;
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
        SpinnerTratamiento();
        SpinnerDoctores();
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
                    String[] items = new String[sedes.size() + 1]; // Agregar 1 al tamaño para el elemento personalizado
                    items[0] = "Seleccionar opción"; // Elemento personalizado en la primera posición
                    for (int i = 0; i < sedes.size(); i++) {
                        items[i + 1] = sedes.get(i).getDireccion();
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterUser.this, android.R.layout.simple_list_item_1, items);
                    _spSede.setAdapter(adapter);
                    _spSede.setSelection(0);
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
    public void SpinnerTratamiento()
    {
        Call<List<Tratamiento>> call= apiService.getTratamiento();
        call.enqueue(new Callback<List<Tratamiento>>() {
            @Override
            public void onResponse(Call<List<Tratamiento>> call, Response<List<Tratamiento>> response) {
                if(response.isSuccessful())
                {
                    tratamientos = response.body();
                    String[] items = new String[tratamientos.size() + 1]; // Agregar 1 al tamaño para el elemento personalizado
                    items[0] = "Seleccionar opción"; // Elemento personalizado en la primera posición
                    for (int i = 0; i < tratamientos.size(); i++) {
                        items[i + 1] = tratamientos.get(i).getNombre();
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterUser.this, android.R.layout.simple_list_item_1, items);
                    _spTratamiento.setAdapter(adapter);
                    _spTratamiento.setSelection(0);
                }
            }
            @Override
            public void onFailure(Call<List<Tratamiento>> call, Throwable t) {
                AlertDialog.Builder error = new AlertDialog.Builder(RegisterUser.this);
                error.setMessage("No hay tratamiento");
                error.show();
                t.printStackTrace();

            }
        });
    }
    public void SpinnerDoctores()
    {
        Call<List<Doctor>> call= apiService.getDoctor();
        call.enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                if(response.isSuccessful())
                {
                    doctors = response.body();
                    String[] items = new String[doctors.size() + 1]; // Agregar 1 al tamaño para el elemento personalizado
                    items[0] = "Seleccionar opción"; // Elemento personalizado en la primera posición
                    for (int i = 0; i < doctors.size(); i++) {
                        items[i + 1] = doctors.get(i).getNombre()+ " "+doctors.get(i).getApellidoPaterno()+" "+doctors.get(i).getApellidoMaterno();
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterUser.this, android.R.layout.simple_list_item_1, items);
                    _spDoctor.setAdapter(adapter);
                    _spDoctor.setSelection(0);
                }
            }
            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {
                AlertDialog.Builder error = new AlertDialog.Builder(RegisterUser.this);
                error.setMessage("No hay tratamiento");
                error.show();
                t.printStackTrace();

            }
        });
    }
}