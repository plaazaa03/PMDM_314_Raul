package com.dam.pmdm_314_raul;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.dam.pmdm_314_raul.R;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTabla;
    private Button btnMostrar;
    private TextView textViewTabla;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerTabla = findViewById(R.id.spinnerTabla);
        btnMostrar = findViewById(R.id.btnMostrar);
        textViewTabla = findViewById(R.id.textViewTabla);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.tablas_multiplicar,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTabla.setAdapter(adapter);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarTabla();
            }
        });
    }

    private void mostrarTabla() {
        int numeroTabla = Integer.parseInt(spinnerTabla.getSelectedItem().toString());
        StringBuilder tabla = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int resultado = numeroTabla * i;
            tabla.append(numeroTabla).append(" x ").append(i).append(" = ").append(resultado).append("\n");
        }

        textViewTabla.setText(tabla.toString());
    }
}
