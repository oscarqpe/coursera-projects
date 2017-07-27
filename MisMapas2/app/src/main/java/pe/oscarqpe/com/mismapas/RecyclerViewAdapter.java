package pe.oscarqpe.com.mismapas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by oscarqpe on 27/07/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UbicacionViewHolder>  {
    List<Ubicacion> ubicaciones;
    Activity activity;

    public RecyclerViewAdapter (List<Ubicacion> ubicaciones, Activity activity){
        this.ubicaciones = ubicaciones;
        this.activity = activity;
    }

    @Override
    public UbicacionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        RecyclerViewAdapter.UbicacionViewHolder pvh = new RecyclerViewAdapter.UbicacionViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(UbicacionViewHolder holder, int position) {
        final Ubicacion ubicacion = ubicaciones.get(position);
        holder.imagen.setImageResource(ubicacion.getImagen());
        //holder.nombre.setText(ubicacion.getNombre().toString());
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.putExtra("latitud", ubicacion.getLatitud());
                intent.putExtra("longitud", ubicacion.getLongitud());
                intent.putExtra("nombre", ubicacion.getNombre());
                intent.putExtra("icon", ubicacion.getIcon());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ubicaciones.size();
    }

    public static class UbicacionViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView imagen;
        //private TextView nombre;

        UbicacionViewHolder (View v) {
            super(v);
            cv = (CardView) v.findViewById(R.id.cv_mapa);
            imagen = (ImageView) v.findViewById(R.id.img_foto);
        }
    }
}
