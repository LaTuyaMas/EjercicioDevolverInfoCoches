package com.example.ejerciciodevolverinfocoches;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerciciodevolverinfocoches.modelos.Bici;
import com.example.ejerciciodevolverinfocoches.modelos.Coche;
import com.example.ejerciciodevolverinfocoches.modelos.Moto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variables de vista
    private TextView txtCoche;
    private TextView txtMoto;
    private TextView txtBici;
    private Button btnCoche;
    private Button btnMoto;
    private Button btnBici;

    //Variables de logica
    private ArrayList<Coche> listaCoches;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Bici> listaBicis;

    //Variables de retorno
    private ActivityResultLauncher<Intent> cochesLauncher;
    private ActivityResultLauncher<Intent> motosLauncher;
    private ActivityResultLauncher<Intent> bicisLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Eventos de Vista
        InicializarVariables();
        //Eventos de Retorno
        InicializaActivitiesResultLaunchers();
        //Me cambia el contador de cada cosa a su número más actual
        ActualizarListas();

        btnCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearCoche.class);
                cochesLauncher.launch(intent);
            }
        });
        btnMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearMoto.class);
                motosLauncher.launch(intent);
            }
        });
        btnBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearBici.class);
                bicisLauncher.launch(intent);
            }
        });
    }

    private void InicializarVariables(){
        txtCoche = findViewById(R.id.txtcocheMain);
        txtMoto = findViewById(R.id.txtMotoMain);
        txtBici = findViewById(R.id.txtBiciMain);
        btnCoche = findViewById(R.id.btnCocheMain);
        btnMoto = findViewById(R.id.btnMotoMain);
        btnBici = findViewById(R.id.btnBiciMain);
        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaBicis = new ArrayList<>();
    }

    private void InicializaActivitiesResultLaunchers(){
        cochesLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                if (result.getData().getExtras().getSerializable("CC")!= null){
                                    Coche coche = (Coche) result.getData().getExtras().getSerializable("CC");
                                    listaCoches.add(coche);
                                    ActualizarListas();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "PAQUETE INCORRECTO", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(MainActivity.this, "PAQUETE VACIO", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "CANCELADO", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        motosLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                if (result.getData().getExtras().getSerializable("CM")!= null){
                                    Moto moto = (Moto) result.getData().getExtras().getSerializable("CM");
                                    listaMotos.add(moto);
                                    ActualizarListas();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "PAQUETE INCORRECTO", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(MainActivity.this, "PAQUETE VACIO", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "CANCELADO", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        bicisLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                if (result.getData().getExtras().getSerializable("CB")!= null){
                                    Bici bici = (Bici) result.getData().getExtras().getSerializable("CB");
                                    listaBicis.add(bici);
                                    ActualizarListas();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "PAQUETE INCORRECTO", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(MainActivity.this, "PAQUETE VACIO", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "CANCELADO", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    @SuppressLint("SetTextI18n")
    private void ActualizarListas(){
        txtCoche.setText("Coches: "+listaCoches.size());
        txtMoto.setText("Motos: "+listaMotos.size());
        txtBici.setText("Bicis: "+listaBicis.size());
    }
}