package com.vilcapoma.misgastosapp.models;

public class Operation {
    double monto;
    String operacion;
    String tipo;

    public Operation(double monto, String operacion, String tipo) {
        this.monto = monto;
        this.operacion = operacion;
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
