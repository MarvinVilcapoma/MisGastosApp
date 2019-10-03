package com.vilcapoma.misgastosapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.vilcapoma.misgastosapp.R;
import com.vilcapoma.misgastosapp.models.Operation;
import com.vilcapoma.misgastosapp.repositories.OperationRespository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    Spinner spinner;
    Button registro;
    RadioButton rbtn1;
    RadioButton rbtn2;
    EditText monto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = findViewById(R.id.spinner_tipo);
        registro = findViewById(R.id.btnRegistrar);
        rbtn1 = findViewById(R.id.rbtnIngreso);
        rbtn2 = findViewById(R.id.rbtnEgreso);
        monto = findViewById(R.id.etMonto);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

    }

    private void add(){
        String operacion = spinner.getSelectedItem().toString();
        String cantidad = monto.getText().toString();
        String tipo;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        if(rbtn1.isChecked()){
            tipo = "Ingresos";
        }else{
            tipo = "Egresos";
        }
        OperationRespository.agregar(date, cantidad, operacion, tipo);
        Intent e = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(e);
        finish();
    }
}
