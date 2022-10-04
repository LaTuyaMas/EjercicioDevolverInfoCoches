package com.example.ejerciciodevolverinfocoches.modelos;

import java.io.Serializable;

public class Moto implements Serializable {
    private String Marca;
    private String Modelo;
    private int cc;

    public Moto() {}

    public Moto(String marca, String modelo, int cc) {
        Marca = marca;
        Modelo = modelo;
        this.cc = cc;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
}
