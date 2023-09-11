package com.example.sqlite.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {


    private  Context context;
    private static final String BD ="Alumno";
    private static final int version=2;


    public Conexion(@Nullable Context context) {
        super(context, BD, null , version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE contactos (id INT PRIMARY KEY, nombre TEXT, apellido TEXT, correo TEXT, carrera TEXT)";
        db.execSQL(query);

        query="CREATE TABLE carreras (id INT PRIMARY KEY , nombre TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS contactos");
        onCreate(db);

    }

    public void agregar(Contacto contacto){

        Toast.makeText(context,"Guardando...", Toast.LENGTH_LONG);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("id",contacto.getId());
        values.put("nombre" , contacto.getNombre().toString());
        values.put("apellido" , contacto.getApellido().toString());
        values.put("correo" , contacto.getCorreo().toString());
        values.put("carrera" , contacto.getCarrera().toString());

        long result =  db.insert("contactos" , null , values);

        if (result==-1){
            Toast.makeText(context,"Error!!! ", Toast.LENGTH_LONG);
        }else {
            Toast.makeText(context,"Alumno agregado correctamente...", Toast.LENGTH_LONG);
        }


    }

    public void agregarC(mdlCarrera carrera){

        Toast.makeText(context,"Guardando...", Toast.LENGTH_LONG).show();
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("id" , carrera.getId());
        values.put("nombre" , carrera.getNombre().toString());

        long result =  db.insert("carreras" , null , values);

        if (result==-1){
            Toast.makeText(context,"Error!!! ", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"Carrera agregada correctamente...", Toast.LENGTH_LONG).show();
        }


    }
    public Cursor consultar(){

        String query="Select * FROM contactos";

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);


        if (cursor==null){

            cursor=db.rawQuery(query,null);
        }

        return cursor;
    }

    public Cursor consultarC(){

        String query="Select * FROM carreras";

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor = null;

        if (cursor==null){

            cursor=db.rawQuery(query,null);
        }

        return cursor;
    }



    public void actualizar(Contacto contacto){

        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put("nombre" , contacto.getNombre().toString());
        values.put("apellido", contacto.getApellido().toString());
        values.put("correo", contacto.getCorreo().toString());
        values.put("carrera", contacto.getCarrera().toString());

        long result = db.update("contactos",values,"id="+contacto.getId(),null);

        if (result==-1){
            Toast.makeText(context,"Error!!! ", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"Carrera modificada correctamente...", Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarC(mdlCarrera carrera){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put("nombre" , carrera.getNombre());


        long result= db.update("carreras",values,"id="+carrera.getId(),null);

        if (result==-1){
            Toast.makeText(context,"Error!!! ", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"Carrera agregada correctamente...", Toast.LENGTH_LONG).show();
        }

    }

    public  void eliminar (Contacto contacto){

        SQLiteDatabase db = this.getReadableDatabase();

        db.delete("contactos" , "id="+contacto.getId(), null);
    }

    public  void eliminarC (mdlCarrera carrera){

        SQLiteDatabase db = this.getReadableDatabase();

        db.delete("carreras" , "id="+carrera.getId(), null);
    }

}
