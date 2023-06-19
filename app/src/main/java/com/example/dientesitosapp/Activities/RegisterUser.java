package com.example.dientesitosapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.dientesitosapp.R;

public class RegisterUser extends AppCompatActivity {
    private   Button    btnRegistar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
    }
}