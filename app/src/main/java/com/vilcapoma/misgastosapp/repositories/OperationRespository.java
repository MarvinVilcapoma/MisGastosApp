package com.vilcapoma.misgastosapp.repositories;

import android.graphics.Path;

import com.vilcapoma.misgastosapp.models.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationRespository {
    private static List<Operation> operations;
    static {
        operations=new ArrayList<>();
    }
    public static List<Operation> getOperation(String operacion) {
        List<Operation> temp = new ArrayList<>();
        for(int m = 0; m < operations.size(); m++){
            if(operations.get(m).getOperacion().equals(operacion)){
                temp.add(operations.get(m));
            }
        }
        return temp;
    }



    public static void agregar(String fecha, String monto, String operacion, String tipo){
        operations.add(new Operation(fecha, monto, operacion, tipo));
    };

    public static double total(String operacion){
        double total = 0;
        double total_ingresos = 0;
        double total_egresos = 0;
        for(int i = 0; i < operations.size(); i++){
            if(operations.get(i).getOperacion().equals(operacion)){
                if (operations.get(i).getTipo().equals("Ingresos")){
                    double numero1 = Double.parseDouble(operations.get(i).getMonto());
                    total_ingresos = total_ingresos + numero1;
                }else{
                    double numero2 = Double.parseDouble(operations.get(i).getMonto());
                    total_egresos = total_egresos + numero2;
                }
            }
        }
        total = total_ingresos - total_egresos;
        return total;
    }

    public static double total_global(){
        double sumatoria_egresos = 0;
        double sumatoria_ingresos = 0;
        double sumatoria = 0;
        for(int m = 0; m < operations.size(); m++){
            if(operations.get(m).getTipo().equals("Ingresos")){
                double numero1 = Double.parseDouble(operations.get(m).getMonto());
                sumatoria_ingresos = sumatoria_ingresos + numero1;
            }else{
                double numero2 = Double.parseDouble(operations.get(m).getMonto());
                sumatoria_egresos = sumatoria_egresos + numero2;
            }
        }
        sumatoria = (sumatoria_ingresos/(sumatoria_egresos+sumatoria_ingresos))*100;
        return sumatoria;
    }
}
