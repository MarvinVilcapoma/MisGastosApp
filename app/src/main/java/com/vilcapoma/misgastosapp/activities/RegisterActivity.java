package com.vilcapoma.misgastosapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.vilcapoma.misgastosapp.R;
import com.vilcapoma.misgastosapp.models.Operation;
import com.vilcapoma.misgastosapp.repositories.OperationRespository;

public class RegisterActivity extends AppCompatActivity {

    private EditText monto;
    private RadioGroup grupo,grupo1;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        monto=findViewById(R.id.etMonto);
        grupo=(RadioGroup)findViewById(R.id.rgIngresoEgreso);
        grupo1=(RadioGroup)findViewById(R.id.rgTipoCuenta);
        registrar=findViewById(R.id.btnRegistrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

    private void registrar(){

        String operacion= "";
        String tipo ="";
        double mon=Double.parseDouble(monto.toString());
        if (grupo.getCheckedRadioButtonId()==R.id.rbtnIngreso){
            operacion = "Ingreso";
        }else if(grupo.getCheckedRadioButtonId()==R.id.rbtnEgreso){
            operacion = "Egreso";

        }else if(grupo1.getCheckedRadioButtonId()==R.id.rbtnAhorro){
            tipo="Ahorro";
        }else if(grupo1.getCheckedRadioButtonId()==R.id.rbtnEfectivo){
            tipo="Efectivo";
        }else if(grupo1.getCheckedRadioButtonId()==R.id.rbtnTarjeta){
            tipo="Tarjeta de Credito";
        }

        Operation operation = new Operation(mon,operacion,tipo);
        OperationRespository.add(operation);




    }

    public void registrar(View view) {
        Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
