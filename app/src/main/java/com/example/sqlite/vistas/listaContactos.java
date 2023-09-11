package com.example.sqlite.vistas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sqlite.R;
import com.example.sqlite.modelo.Conexion;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class listaContactos extends AppCompatActivity {

    RecyclerView lista;

    FloatingActionButton btnAgregar;

    Conexion con;

    ArrayList<String> ids ,nombre,apellido,correo,carrera;

    Adaptador adaptador;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);

        lista = findViewById(R.id.lista);
        btnAgregar = findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(listaContactos.this, Agregar.class);
                startActivity(intent);
            }
        });

        con = new Conexion(this);


        ids=new ArrayList<String>();
        nombre=new ArrayList<String>();
        apellido=new ArrayList<String>();
        correo=new ArrayList<String>();
        carrera=new ArrayList<String>();

        prepararDatos();

        adaptador = new Adaptador(this,ids,nombre,apellido,correo,carrera);

        lista.setAdapter(adaptador);

        lista.setLayoutManager(new LinearLayoutManager(this));


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation2);

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

    void prepararDatos(){
        Cursor cursor = con.consultar();

        if (cursor.getCount() == 0){

            Toast.makeText(this,"Aun no hay Registro", Toast.LENGTH_LONG);

        }else {
            while (cursor.moveToNext()){
                ids.add("" + cursor.getInt(0));
                nombre.add(cursor.getString(1));
                apellido.add(cursor.getString(2));
                correo.add(cursor.getString(3));
                carrera.add(cursor.getString(4));
            }
        }
    }
}
