package com.codedwar.edwar.mascotas;

import java.util.ArrayList;

/**
 * Created by Edwar on 05/09/2016.
 */
public class Comunicador {
    private static ArrayList<Mascotas> listaMascotas = new ArrayList<Mascotas>();

    public static ArrayList<Mascotas> getListaMascotas() {
        return listaMascotas;
    }

    public static void setListaMascotas(ArrayList<Mascotas> listaMascotas) {
        Comunicador.listaMascotas = listaMascotas;
    }
}
