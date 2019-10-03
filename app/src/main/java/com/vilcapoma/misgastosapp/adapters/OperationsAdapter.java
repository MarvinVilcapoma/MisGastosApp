package com.vilcapoma.misgastosapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vilcapoma.misgastosapp.R;
import com.vilcapoma.misgastosapp.models.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationsAdapter extends RecyclerView.Adapter<OperationsAdapter.ViewHolder> {

    private List<Operation> operaciones;

    public void setOperaciones(List<Operation> operaciones) {
        this.operaciones = operaciones;
    }

    public OperationsAdapter(){
        this.operaciones = new ArrayList<>();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView monto, titulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            monto = itemView.findViewById(R.id.montotrans);
            titulo = itemView.findViewById(R.id.titulotrans);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_operation, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Operation operation = this.operaciones.get(i);
        viewHolder.titulo.setText(operation.getFecha()+ " " + operation.getTipo() );
        viewHolder.monto.setText("S/. "+operation.getMonto()+"                                ");

    }

    @Override
    public int getItemCount() {
        return this.operaciones.size();
    }
}
