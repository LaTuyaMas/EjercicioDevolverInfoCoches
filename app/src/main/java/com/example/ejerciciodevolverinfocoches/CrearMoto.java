package com.example.ejerciciodevolverinfocoches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejerciciodevolverinfocoches.modelos.Moto;

public class CrearMoto extends AppCompatActivity {

    //Variables de Vista
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCC;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_moto);

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
                Moto moto = new Moto(
                        txtMarca.getText().toString(),
                        txtModelo.getText().toString(),
                        Integer.parseInt(txtCC.getText().toString())
                );
                Bundle bundle = new Bundle();
                bundle.putSerializable("CM", moto);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void InicializarVistas() {
        txtMarca = findViewById(R.id.txtMarcaCM);
        txtModelo = findViewById(R.id.txtModeloCM);
        txtCC = findViewById(R.id.txtCCCM);
        btnCancelar = findViewById(R.id.btnCancelarCM);
        btnCrear = findViewById(R.id.btnCrearCM);
    }
}