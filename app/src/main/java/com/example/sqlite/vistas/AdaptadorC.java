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

public class AdaptadorC extends RecyclerView.Adapter<AdaptadorC.Vista>{


    private Context context;

    private ArrayList<String> ids;

    private ArrayList<String> nombre;

    ConstraintLayout fila;



    public AdaptadorC(Context context, ArrayList<String> ids ,
                     ArrayList<String> nombre){

        this.context=context;
        this.ids=ids;
        this.nombre=nombre;

    }

    @NonNull
    @NotNull
    @Override

    public AdaptadorC.Vista onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.elemento_c , parent,false);

        return new AdaptadorC.Vista(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdaptadorC.Vista holder, @SuppressLint("RecyclerView") int position) {

        holder.txtIdC.setText(ids.get(position));
        holder.txtNombreC.setText(nombre.get(position));


        fila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActualizarC.class);

                intent.putExtra("id", ids.get(position));
                intent.putExtra("nombre", nombre.get(position));

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return nombre.size();
    }

    public class Vista extends RecyclerView.ViewHolder{

        TextView txtIdC , txtNombreC;




        public Vista(@NonNull @NotNull View itemView) {
            super(itemView);

            txtIdC = itemView.findViewById(R.id.txtidC);
            txtNombreC = itemView.findViewById(R.id.txtNombreC);

            fila = itemView.findViewById(R.id.fila);


        }
    }
}
