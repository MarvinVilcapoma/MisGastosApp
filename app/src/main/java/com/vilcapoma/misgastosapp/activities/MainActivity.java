package com.vilcapoma.misgastosapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.vilcapoma.misgastosapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView t1,t2,t3;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.tvMontoAhorro);
        t2=findViewById(R.id.tvMontoEfectivo);
        t3=findViewById(R.id.tvMontoCredito);


    }

    public void callRegistrar(View view) {

        Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void detail1(View view) {
        Intent intent=new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);
    }
}
