package com.vilcapoma.misgastosapp.repositories;

import android.graphics.Path;

import com.vilcapoma.misgastosapp.models.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationRespository {
    private static List<Operation> operations;
    static {
        operations=new ArrayList<>();
        operations.add( new Operation(2000.00,"Ingreso","Ahorro"));
    }
    public static List<Operation>getOperations(){
        return operations;
    }

    public static void add(Operation operation){
        operations.add(0,operation);
    }

}
