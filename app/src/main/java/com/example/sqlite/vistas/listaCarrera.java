package com.example.sqlite.vistas;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class listaCarrera extends AppCompatActivity {

    RecyclerView listaC;

    FloatingActionButton btnAgregarC;

    Conexion con;

    ArrayList<String> ids ,nombre;

    AdaptadorC adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carrera);

        listaC = findViewById(R.id.listaC);
        btnAgregarC = findViewById(R.id.btnAgregarC);

        btnAgregarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(listaCarrera.this, frmAgregarC.class);
                startActivity(intent);
            }
        });

        con = new Conexion(this);


        ids=new ArrayList<String>();
        nombre=new ArrayList<String>();


        prepararDatos();

        adaptador = new AdaptadorC(this,ids,nombre);

        listaC.setAdapter(adaptador);

        listaC.setLayoutManager(new LinearLayoutManager(this));
    }

    void prepararDatos(){
        Cursor cursor = con.consultarC();

        if (cursor.getCount() == 0){
            Toast.makeText(this,"Aun no hay Registro", Toast.LENGTH_LONG);
        }else {
            while (cursor.moveToNext()){
                ids.add("" + cursor.getInt(0));
                nombre.add(cursor.getString(1));
            }
        }
    }

}