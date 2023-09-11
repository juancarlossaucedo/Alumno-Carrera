package com.example.sqlite.vistas;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sqlite.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Button btnContactos , btnCarrera;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnContactos= findViewById(R.id.btnContactos);
        btnCarrera= findViewById(R.id.btnCarrera);

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        btnContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listaContactos.class);
                startActivity(intent);
            }
        });

        btnCarrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listaCarrera.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            Intent home = new Intent(this, MainActivity.class);
                            startActivity(home);
                            return true;

                        case R.id.navigation_alumno:
                            Intent alumno = new Intent(this, listaContactos.class);
                            startActivity(alumno);
                            return true;
                        case R.id.navigation_carrera:
                            Intent carrera = new Intent(this, listaCarrera.class);
                            startActivity(carrera);
                            return true;
                    }
                    return false;
                }
        );


    }
}