package pe.oscarqpe.com.mismascotas;

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
import java.util.List;

/**
 * Created by oscarqpe on 22/07/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MascotaViewHolder> {
    List<Mascota> mascotas;
    Activity activity;
    public RVAdapter(List<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @Override
    public int getItemCount() {
        return mascotas.size();
    }
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView imagen;
        private TextView nombre;
        private TextView rating;
        private ImageButton btn_like;

        MascotaViewHolder (View v) {
            super(v);
            cv = (CardView) v.findViewById(R.id.cv_mascotas);
            imagen = (ImageView) v.findViewById(R.id.img_foto);
            nombre = (TextView) v.findViewById(R.id.tv_nombre_mascota);
            rating = (TextView) v.findViewById(R.id.tv_raiting);
            btn_like = (ImageButton) v.findViewById(R.id.btn_raiting);
        }
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int i) {
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
        mascotaViewHolder.rating.setText(Integer.toString(mascota.getLikes()));

        mascotaViewHolder.btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "+1 LIKE " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.setLikes(mascota.getLikes() + 1);
                mascotaViewHolder.rating.setText(Integer.toString(mascota.getLikes()));
            }
        });
    }
}
