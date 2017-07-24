package pe.oscarqpe.com.mismascotaswebservice.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;
import pe.oscarqpe.com.mismascotaswebservice.R;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class RVPAdapter extends RecyclerView.Adapter<RVPAdapter.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public RVPAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @Override
    public int getItemCount() {
        if (mascotas == null)
            return 0;
        return mascotas.size();
    }
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView imagen;
        private TextView rating;

        MascotaViewHolder (View v) {
            super(v);
            cv = (CardView) v.findViewById(R.id.cv_mascotas_profile);
            imagen = (ImageView) v.findViewById(R.id.img_foto);
            rating = (TextView) v.findViewById(R.id.tv_raiting);
        }
    }
    @Override
    public RVPAdapter.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_profile, parent, false);
        RVPAdapter.MascotaViewHolder pvh = new RVPAdapter.MascotaViewHolder(v);
        return pvh;
    }
    @Override
    public void onBindViewHolder(final RVPAdapter.MascotaViewHolder mascotaViewHolder, int position) {
        // Asociar cada elemento con cada view
        final Mascota mascota = mascotas.get(position);
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.mascotas10)
                .into(mascotaViewHolder.imagen);
        mascotaViewHolder.rating.setText(Integer.toString(mascota.getLikes()));
    }
}
