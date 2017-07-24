package pe.oscarqpe.com.mismascotaswebservice.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pe.oscarqpe.com.mismascotaswebservice.model.ConstructorMascota;
import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;
import pe.oscarqpe.com.mismascotaswebservice.R;

/**
 * Created by oscarqpe on 22/07/17.
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
        private TextView rating;

        MascotaViewHolder (View v) {
            super(v);
            cv = (CardView) v.findViewById(R.id.cv_mascotas);
            imagen = (ImageView) v.findViewById(R.id.img_foto);
            rating = (TextView) v.findViewById(R.id.tv_raiting);
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
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.mascotas10)
                .into(mascotaViewHolder.imagen);
        mascotaViewHolder.rating.setText(Integer.toString(mascota.getLikes()));
    }
}
