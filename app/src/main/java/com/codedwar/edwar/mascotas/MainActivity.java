package com.codedwar.edwar.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascotas> mascota;
    private RecyclerView rvListaMascostas;
    ArrayList<Mascotas> favoritas;
    Comunicador comunicador = new Comunicador();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miToolbar);

        rvListaMascostas = (RecyclerView)findViewById(R.id.rvListaMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascostas.setLayoutManager(llm);
        inicializarDatos();
        inicializarAdapter();





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.avFavoritos) {
            favoritas = new ArrayList<Mascotas>();

            MascotaAdapter mascotaAdapter = new MascotaAdapter();

            Toast.makeText(this, "Hay : "+favoritas.size(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MascotasFavoritas.class);

            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascota,this);
        rvListaMascostas.setAdapter(mascotaAdapter);
    }
}
