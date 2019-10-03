package com.vilcapoma.misgastosapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vilcapoma.misgastosapp.R;
import com.vilcapoma.misgastosapp.repositories.OperationRespository;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    TextView ahorro,credito,efectivo,montoaho, montocre, montoefe;
    ProgressBar progressBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fabadd);
        ahorro = findViewById(R.id.tvAhorro);
        credito = findViewById(R.id.tvCredito);
        efectivo = findViewById(R.id.tvEfectivo);
        montoaho = findViewById(R.id.tvMontoAhorro);
        montocre = findViewById(R.id.tvMontoCredito);
        montoefe = findViewById(R.id.tvMontoEfectivo);
        progressBar = findViewById(R.id.progress_bar);

        double numero = OperationRespository.total_global();
        Log.e("main","monto: "+numero);
        progressBar.setProgress((int)Math.round(numero));

        montoaho.setText("S/. "+String.valueOf(OperationRespository.total("Ahorro")));
        montocre.setText("S/. "+String.valueOf(OperationRespository.total("Tarjeta de Credito")));
        montoefe.setText("S/. "+String.valueOf(OperationRespository.total("Efectivo")));

        ahorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(getApplicationContext(), DetailActivity.class);
                q.putExtra("valor", "Ahorro");
                startActivity(q);
            }
        });


        credito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(), DetailActivity.class);
                p.putExtra("valor", "Tarjeta de Credito");
                startActivity(p);
            }
        });


        efectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(getApplicationContext(), DetailActivity.class);
                w.putExtra("valor", "Efectivo");
                startActivity(w);

            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
