package com.codedwar.edwar.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    ArrayList<Mascotas> mascota;
    ArrayList<Mascotas> favoritas;
    private RecyclerView rvListaMascostas;
    Comunicador comunicador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        comunicador = new Comunicador();
        rvListaMascostas = (RecyclerView)findViewById(R.id.rvListaMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascostas.setLayoutManager(llm);
        //traerFavoritas();
        //inicializarDatos();
        favoritas = comunicador.getListaMascotas();
        inicializarAdapter();


    }

    public void inicializarDatos(){
        mascota = new ArrayList<Mascotas>();

        mascota.add(new Mascotas(R.drawable.mascota1,"blaze",0));
        mascota.add(new Mascotas(R.drawable.mascota2,"payasa",0));
        mascota.add(new Mascotas(R.drawable.mascota3,"chester",0));
        mascota.add(new Mascotas(R.drawable.mascota4,"fifi",0));
        mascota.add(new Mascotas(R.drawable.mascota5,"coqueta",0));
        mascota.add(new Mascotas(R.drawable.mascota6,"rudo",0));
    }

    public void inicializarAdapter(){
        FavoritosAdapter mascotaAdapter = new FavoritosAdapter(favoritas);
        rvListaMascostas.setAdapter(mascotaAdapter);

    }

    public void traerFavoritas(){
        MascotaAdapter mascotaAdapter = new MascotaAdapter();
        favoritas = new ArrayList<Mascotas>();
        favoritas = mascotaAdapter.listaFavoritos();
    }


}
