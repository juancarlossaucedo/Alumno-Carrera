package com.example.sqlite.vistas;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sqlite.R;
import com.example.sqlite.modelo.Conexion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnContactos , btnCarrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnContactos= findViewById(R.id.btnContactos);
        btnCarrera= findViewById(R.id.btnCarrera);



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


    }
}