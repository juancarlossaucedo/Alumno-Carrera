package com.example.sqlite.vistas;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sqlite.R;
import com.example.sqlite.modelo.Conexion;
import com.example.sqlite.modelo.Contacto;

import java.util.ArrayList;

public class Agregar extends AppCompatActivity {

    EditText txtID , txtNombre , txtApellido , txtCorreo;

    Button btnGuardar;

    Spinner spCarrera;

    Conexion con;

    ArrayList<String> ids= new ArrayList<String>();
    ArrayList<String> nombre= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);


        txtID=findViewById(R.id.txtID);
        txtNombre=findViewById(R.id.txtNombre);
        txtApellido=findViewById(R.id.txtApellido);
        txtCorreo=findViewById(R.id.txtCorreo);

        spCarrera=findViewById(R.id.spCarrera);

        btnGuardar=findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Conexion con = new Conexion(Agregar.this);
                Contacto contacto = new Contacto();

                contacto.setId(Integer.parseInt(txtID.getText().toString().trim()));

                contacto.setNombre(txtNombre.getText().toString().trim());
                contacto.setApellido(txtApellido.getText().toString().trim());
                contacto.setCorreo(txtCorreo.getText().toString().trim());
                contacto.setCarrera(spCarrera.getSelectedItem().toString());

                con.agregar(contacto);

                Intent intent =new Intent(Agregar.this, listaContactos.class);

                startActivity(intent);
            }
        });

        prepararDatosC();

        spCarrera.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item
        , nombre));
    }

    public void prepararDatosC(){
        con=new Conexion(this);

        Cursor cursor = con.consultarC();

        if (cursor.getCount() !=0 ){

            while (cursor.moveToNext()){
                ids.add(""+cursor.getInt(0));
                nombre.add(cursor.getString(1));
            }
        }
    }
}