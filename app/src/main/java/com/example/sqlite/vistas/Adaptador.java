package com.example.sqlite.vistas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sqlite.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adaptador  extends RecyclerView.Adapter<Adaptador.Vista> {

    private Context context;

    private ArrayList<String> ids;

    private ArrayList<String> nombre;
    private ArrayList<String> apellido;

    private ArrayList<String> correo;

    private ArrayList<String> carrera;

    ConstraintLayout fila;

    public Adaptador(Context context, ArrayList<String> ids ,
                     ArrayList<String> nombre ,
                     ArrayList<String> apellido ,
                     ArrayList<String> correo,
                     ArrayList<String> carrera){

        this.context=context;
        this.ids=ids;
        this.nombre=nombre;
        this.apellido=apellido;
        this.correo=correo;
        this.carrera=carrera;

    }
    @NonNull
    @NotNull
    @Override
    public Adaptador.Vista onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.elemento , parent,false);

        return new Vista(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Adaptador.Vista holder, @SuppressLint("RecyclerView") final int position) {

        holder.txtShoNombre.setText(nombre.get(position));
        holder.txtShoApellido.setText(apellido.get(position));


        fila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Actualizar.class);

                intent.putExtra("id", ids.get(position));
                intent.putExtra("nombre", nombre.get(position));
                intent.putExtra("apellido", apellido.get(position));
                intent.putExtra("correo", correo.get(position));
                intent.putExtra("carrera", carrera.get(position));

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return nombre.size();
    }

    public class Vista extends RecyclerView.ViewHolder{

        TextView txtShoNombre , txtShoApellido;



        public Vista(@NonNull @NotNull View itemView) {
            super(itemView);

            txtShoNombre = itemView.findViewById(R.id.txtShoNombre);
            txtShoApellido = itemView.findViewById(R.id.textShoApellido);

            fila = itemView.findViewById(R.id.fila);


        }
    }
}
