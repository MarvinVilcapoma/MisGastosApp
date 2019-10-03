package com.vilcapoma.misgastosapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.vilcapoma.misgastosapp.R;
import com.vilcapoma.misgastosapp.adapters.OperationsAdapter;
import com.vilcapoma.misgastosapp.repositories.OperationRespository;

public class DetailActivity extends AppCompatActivity {

    TextView monto, detalle;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detalle = findViewById(R.id.titulodetalle);
        monto = findViewById(R.id.montoSuma);
        recyclerView = findViewById(R.id.operations_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String res = getIntent().getExtras().getString("valor");
        OperationsAdapter adapter = new OperationsAdapter();
        adapter.setOperaciones(OperationRespository.getOperation(res));
        monto.setText(String.valueOf(OperationRespository.total(res)));
        detalle.setText("Saldo Actual "+res);
        recyclerView.setAdapter(adapter);

    }
}
