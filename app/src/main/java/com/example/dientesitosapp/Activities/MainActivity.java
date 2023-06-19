package com.example.dientesitosapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dientesitosapp.R;

public class MainActivity extends AppCompatActivity {
            private Button btnIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngresar = findViewById(R.id.btn_ingresar);


         btnIngresar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, Login.class);
                 startActivity(intent);
             }
         });
    }
}