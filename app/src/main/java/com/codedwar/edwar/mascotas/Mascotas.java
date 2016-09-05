package com.codedwar.edwar.mascotas;

import java.util.ArrayList;

/**
 * Created by Edwar on 04/09/2016.
 */
public class Mascotas {
    private int fotoMascota;
    private String nombre;
    private int cantidadLikes;



    public Mascotas(int fotoMascota, String nombre, int cantidadLikes) {
        this.fotoMascota = fotoMascota;
        this.nombre = nombre;
        this.cantidadLikes = cantidadLikes;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }
}
