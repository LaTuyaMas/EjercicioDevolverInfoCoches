package com.example.ejerciciodevolverinfocoches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejerciciodevolverinfocoches.modelos.Coche;

public class CrearCoche extends AppCompatActivity {

    //Variables de Vista
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_coche);

        InicializarVistas();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coche coche = new Coche(
                        txtMarca.getText().toString(),
                        txtModelo.getText().toString(),
                        txtColor.getText().toString()
                );
                Bundle bundle = new Bundle();
                bundle.putSerializable("CC", coche);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void InicializarVistas() {
        txtMarca = findViewById(R.id.txtMarcaCC);
        txtModelo = findViewById(R.id.txtModeloCC);
        txtColor = findViewById(R.id.txtColorCC);
        btnCancelar = findViewById(R.id.btnCancelarCC);
        btnCrear = findViewById(R.id.btnCrearCC);
    }
}