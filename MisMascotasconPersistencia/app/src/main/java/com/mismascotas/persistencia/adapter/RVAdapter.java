package com.mismascotas.persistencia.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mismascotas.persistencia.R;
import com.mismascotas.persistencia.model.ConstructorMascota;
import com.mismascotas.persistencia.model.Mascota;

import java.util.ArrayList;

/**
 * Created by oscarqpe on 29/07/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MascotaViewHolder> {
    ArrayList<Mascota> mascotas = new ArrayList<>();
    Activity activity;
    public RVAdapter(ArrayList<Mascota> mascotas, Activity activity){
            this.mascotas = mascotas;
            this.activity = activity;
            }
    @Override
    public int getItemCount() {
            if (mascotas == null)
            return 0;
            return this.mascotas.size();
            }
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView imagen;
        private ImageButton btnLike;
        private TextView nombre;
        private TextView rating;

        MascotaViewHolder (View v) {
            super(v);
            cv = (CardView) v.findViewById(R.id.cv_mascotas);
            imagen = (ImageView) v.findViewById(R.id.img_foto);
            rating = (TextView) v.findViewById(R.id.tv_raiting);
            nombre = (TextView) v.findViewById(R.id.tv_nombre_mascota);
            btnLike = (ImageButton) v.findViewById(R.id.btn_raiting);
        }
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        System.out.print("Create view holder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MascotaViewHolder pvh = new MascotaViewHolder(v);
        return pvh;
    }
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        // Asociar cada elemento con cada view
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imagen.setImageResource(mascota.getFoto());
        mascotaViewHolder.nombre.setText(mascota.getNombre());
        mascotaViewHolder.rating.setText(Integer.toString(mascota.getLikes()) + " LIKES");

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "+1 Like " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorMascota constructorMascota = new ConstructorMascota(activity);
                constructorMascota.darLikeMascota(mascota);
                mascotaViewHolder.rating.setText(constructorMascota.obtenerLikesMascota(mascota) + " LIKES");
            }
        });
    }
}
