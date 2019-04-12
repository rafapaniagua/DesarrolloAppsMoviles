package com.example.empleados.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.empleados.Empleado;
import com.example.empleados.MainActivity;
import com.example.empleados.R;
import com.example.empleados.VistaRapida;

import java.util.List;

public class RVEmpleadoAdapter extends RecyclerView.Adapter<RVEmpleadoAdapter.RVEmpleadoAdapterViewHolder> {
    private Context context;
    private List<Empleado> empleados;

    //Constructor de nuestro adapter
    public RVEmpleadoAdapter(Context context, List<Empleado> empleados) {
        this.context = context;
        this.empleados = empleados;
    }

    //Creamos el item principal que se reciclara en cada uno de los elementos
    @NonNull
    @Override
    public RVEmpleadoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Inflamos nuestra vista de item
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_rv_empleados,
                viewGroup,
                false);

        //Retornamos una instancia del viewholder pasandole como parametro la vista anteriormente creada
        return new RVEmpleadoAdapterViewHolder(view);
    }

    //Se ejecutara por cada elemento de la lista
    @Override
    public void onBindViewHolder(@NonNull RVEmpleadoAdapterViewHolder rvEmpleadoAdapterViewHolder, int i) {
        //Creamos una instancia de tipo "Empleado" dependiendo del lugar de la lista en el que este
        final Empleado empleado = empleados.get(i);

        //Asignamos a las vistas del viewholder los textos del mensaje en esa posicion
        rvEmpleadoAdapterViewHolder.textViewNombre.setText(empleado.getNombre());
        rvEmpleadoAdapterViewHolder.textViewApellidoP.setText(empleado.getApellidoP());
        rvEmpleadoAdapterViewHolder.textViewApellidoM.setText(empleado.getApellidoM());
        rvEmpleadoAdapterViewHolder.textViewNoNomina.setText(empleado.getNoNomina());

        //Asignamos a ese item en particular un listener para cuando el usuario haga click en el
        rvEmpleadoAdapterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle(empleado.getNoNomina());
                alertDialog.setMessage(empleado.getNombre());

                alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.show();*/

                Intent intent = new Intent(v.getContext(), VistaRapida.class);

                intent.putExtra("nombre", empleado.getNombre());
                intent.putExtra("apellidoP", empleado.getApellidoP());
                intent.putExtra("apellidoM", empleado.getApellidoM());
                intent.putExtra("noNomina", empleado.getNoNomina());
                intent.putExtra("telefono", empleado.getTelefono());
                intent.putExtra("area", empleado.getArea());
                intent.putExtra("imagen", empleado.getImagen());

                v.getContext().startActivity(intent);
            }
        });
    }

    //Retornamos el tamaño de la lista
    @Override
    public int getItemCount() {
        return empleados.size();
    }


    public class RVEmpleadoAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        TextView textViewApellidoP;
        TextView textViewApellidoM;
        TextView textViewNoNomina;

        public RVEmpleadoAdapterViewHolder(View view) {
            super(view);

            //Instanciamos nuestros objetos que seran buscados segun si id en la vista pasada por el constructor
            textViewNombre = view.findViewById(R.id.tv_nombre_rv);
            textViewApellidoP = view.findViewById(R.id.tv_apellidoP_rv);
            textViewApellidoM = view.findViewById(R.id.tv_apellidoM_rv);
            textViewNoNomina = view.findViewById(R.id.tv_noNomina_rv);
        }
    }
}
