package com.vilcapoma.misgastosapp.models;

public class Operation {
    String fecha;
    String monto;
    String operacion;
    String tipo;

    public Operation(String fecha, String monto, String operacion, String tipo) {
        this.fecha = fecha;
        this.monto = monto;
        this.operacion = operacion;
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
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
