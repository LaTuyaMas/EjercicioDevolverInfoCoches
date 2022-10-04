package com.example.ejerciciodevolverinfocoches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejerciciodevolverinfocoches.modelos.Bici;
import com.example.ejerciciodevolverinfocoches.modelos.Moto;

public class CrearBici extends AppCompatActivity {

    //Variables de Vista
    private EditText txtMarca;
    private EditText txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bici);

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
                Bici bici = new Bici(
                        txtMarca.getText().toString(),
                        Integer.parseInt(txtPulgadas.getText().toString())
                );
                Bundle bundle = new Bundle();
                bundle.putSerializable("CB", bici);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void InicializarVistas() {
        txtMarca = findViewById(R.id.txtMarcaCB);
        txtPulgadas = findViewById(R.id.txtPulgadasCB);
        btnCancelar = findViewById(R.id.btnCancelarCB);
        btnCrear = findViewById(R.id.btnCrearCB);
    }
}