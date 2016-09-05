package com.codedwar.edwar.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Edwar on 04/09/2016.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    ArrayList<Mascotas> favoritas = new ArrayList<Mascotas>();;
    Activity activity;
    Comunicador comunicador = new Comunicador();

    public  MascotaAdapter(){

    }
    public MascotaAdapter(ArrayList<Mascotas> mascotas, Activity activity ){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascotas mascota = mascotas.get(position);
        //final int cantidad = mascota.getCantidadLikes();

        holder.ivMascota.setImageResource(mascota.getFotoMascota());
        holder.tvNonmbre.setText(mascota.getNombre());
        holder.tvCantidadLikes.setText(""+mascota.getCantidadLikes());
        holder.ivbLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cantidad = mascota.getCantidadLikes();

                holder.tvCantidadLikes.setText(""+suma(cantidad,mascota));
                if(favoritas.size() >= 5){
                    favoritas.remove(0);
                    favoritas.add(new Mascotas(mascota.getFotoMascota(),mascota.getNombre(),mascota.getCantidadLikes()));
                }
                else favoritas.add(new Mascotas(mascota.getFotoMascota(),mascota.getNombre(),mascota.getCantidadLikes()));
                comunicador.setListaMascotas(favoritas);
                //Toast.makeText(activity,"Cantidad "+mascota.getCantidadLikes(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public int suma(int cantidad, Mascotas mascota){
        cantidad += 1;
        mascota.setCantidadLikes(cantidad);
        return mascota.getCantidadLikes();
    }

    public ArrayList<Mascotas> listaFavoritos(){
        return favoritas;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivMascota;
        private TextView tvNonmbre;
        private TextView tvCantidadLikes;
        private ImageButton ivbLike;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            ivMascota       = (ImageView) itemView.findViewById(R.id.imvMascota);
            tvNonmbre       = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCantidadLikes = (TextView) itemView.findViewById(R.id.tvCantidadLikes);
            ivbLike         = (ImageButton) itemView.findViewById(R.id.btnHuesoLike);

        }


    }


}
