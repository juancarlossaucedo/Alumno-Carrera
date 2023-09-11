package com.example.sqlite.vistas;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sqlite.R;
import com.example.sqlite.modelo.Conexion;
import com.example.sqlite.modelo.mdlCarrera;

public class frmAgregarC extends AppCompatActivity {


    EditText txtidC , txtNombreC;

    Button btnGuardarC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_agregar_c);

        txtidC=findViewById(R.id.txtidC);
        txtNombreC=findViewById(R.id.txtNombreC);
        btnGuardarC=findViewById(R.id.btnGuardarC);

        btnGuardarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Conexion con = new Conexion(frmAgregarC.this);
                mdlCarrera carrera = new mdlCarrera();

                carrera.setId(Integer.parseInt(txtidC.getText().toString().trim()));

                carrera.setNombre(txtNombreC.getText().toString().trim());


                con.agregarC(carrera);

                Intent intent =new Intent(frmAgregarC.this, listaCarrera.class);

                startActivity(intent);
            }
        });
    }
}