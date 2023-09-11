package com.example.sqlite.vistas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sqlite.R;
import com.example.sqlite.modelo.Conexion;
import com.example.sqlite.modelo.Contacto;

import java.util.ArrayList;

public class Actualizar extends AppCompatActivity {

    EditText txtMid , txtMnombre, txtMapellido , txtMcorreo;

    Button btnActualizar , btnEliminar;

    Spinner spCarrera2;

    ArrayList<String> ids= new ArrayList<String>();
    ArrayList<String> nombre= new ArrayList<String>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        txtMid=findViewById(R.id.txtID2);
        txtMnombre=findViewById(R.id.txtNombre2);
        txtMapellido=findViewById(R.id.txtApellido2);
        txtMcorreo=findViewById(R.id.txtCorreo2);


        btnActualizar = findViewById(R.id.btnActualizar);

        btnEliminar = findViewById(R.id.btnEliminar);

        spCarrera2= findViewById(R.id.spCarrera);

        btnActualizar.setOnClickListener((v) -> {

                Conexion con = new Conexion(Actualizar.this);
                Contacto contacto = new Contacto();

                contacto.setId(Integer.parseInt(txtMid.getText().toString().trim()));

                contacto.setNombre(txtMnombre.getText().toString().trim());
                contacto.setApellido(txtMapellido.getText().toString().trim());
                contacto.setCorreo(txtMcorreo.getText().toString().trim());
                contacto.setCarrera(spCarrera2.getSelectedItem().toString());


                con.actualizar(contacto);

                Intent intent = new Intent(Actualizar.this, MainActivity.class);

                startActivity(intent);

        });

        btnEliminar.setOnClickListener((v) -> {


                Conexion con = new Conexion(Actualizar.this);

                Contacto contacto = new Contacto();

                contacto.setId(Integer.parseInt(txtMid.getText().toString().trim()));

                con.eliminar(contacto);

                Intent intent = new Intent( Actualizar.this , MainActivity.class);

                startActivity(intent);


        });

        txtMid.setText(getIntent().getStringExtra("id"));
        txtMnombre.setText(getIntent().getStringExtra("nombre"));
        txtMapellido.setText(getIntent().getStringExtra("apellido"));
        txtMcorreo.setText(getIntent().getStringExtra("correo"));


    }

    public void prepararDatosC(){

        Conexion con = new Conexion(Actualizar.this);
        Cursor cursor = con.consultarC();

        if (cursor.getCount() !=0 ){

            while (cursor.moveToNext()){
                ids.add(""+cursor.getInt(0));
                nombre.add(cursor.getString(1));
            }
        }
    }
}