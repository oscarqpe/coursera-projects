package pe.oscarqpe.com.mismascotasdetalle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotasdetalle.Mascota;
import pe.oscarqpe.com.mismascotasdetalle.R;
import pe.oscarqpe.com.mismascotasdetalle.adapter.RVAdapter;
import pe.oscarqpe.com.mismascotasdetalle.adapter.RVPAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_profile_fotos;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rv_profile_fotos = (RecyclerView) v.findViewById(R.id.rv_profile_fotos);

        rv_profile_fotos.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        inicializarMascotas();
        inicializarAdaptador();
        return v;
    }
    //inicializar mascotas
    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 2));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 3));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 4));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 5));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 12));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 4));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 6));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 7));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 3));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 8));
    }
    // inicializar adaptador
    public void inicializarAdaptador(){
        RVPAdapter mascotaAdaptador = new RVPAdapter(mascotas, getActivity());
        rv_profile_fotos.setAdapter(mascotaAdaptador);
    }
}
