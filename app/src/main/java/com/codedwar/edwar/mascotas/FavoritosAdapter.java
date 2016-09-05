package com.codedwar.edwar.mascotas;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Edwar on 05/09/2016.
 */
public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.FavoritosViewHolder>{

    ArrayList<Mascotas> favoritasMascotas;

    public FavoritosAdapter(ArrayList<Mascotas> favoritasMascotas) {
        this.favoritasMascotas = favoritasMascotas;
    }

    @Override
    public FavoritosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);

        return new FavoritosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoritosViewHolder holder, int position) {
        Mascotas mascotas = favoritasMascotas.get(position);
        holder.ivMascota.setImageResource(mascotas.getFotoMascota());
        holder.tvNonmbre.setText(mascotas.getNombre());
        holder.tvCantidadLikes.setText(""+mascotas.getCantidadLikes());
        holder.ivbLike.setEnabled(false);

    }

    @Override
    public int getItemCount() {
        return favoritasMascotas.size();
    }

    public static class FavoritosViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivMascota;
        private TextView tvNonmbre;
        private TextView tvCantidadLikes;
        private ImageButton ivbLike;

        public FavoritosViewHolder(View itemView) {
            super(itemView);
            ivMascota       = (ImageView) itemView.findViewById(R.id.imvMascota);
            tvNonmbre       = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCantidadLikes = (TextView) itemView.findViewById(R.id.tvCantidadLikes);
            ivbLike         = (ImageButton) itemView.findViewById(R.id.btnHuesoLike);
        }
    }
}
