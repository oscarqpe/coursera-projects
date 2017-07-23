package pe.oscarqpe.com.mismascotasdetalle.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotasdetalle.Mascota;
import pe.oscarqpe.com.mismascotasdetalle.R;
import pe.oscarqpe.com.mismascotasdetalle.adapter.RVAdapter;

/**
 * Created by oscarqpe on 22/07/17.
 */

public class RecyclerViewFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rv_mascotas = (RecyclerView) v.findViewById(R.id.rv_mascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(linearLayoutManager);

        inicializarMascotas();
        inicializarAdaptador();

        return v;
    }
    //inicializar mascotas
    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Tobi", R.drawable.mascotas1, 2));
        mascotas.add(new Mascota("Rambo", R.drawable.mascotas2, 3));
        mascotas.add(new Mascota("Firulais", R.drawable.mascotas3, 4));
        mascotas.add(new Mascota("Piter", R.drawable.mascotas4, 5));
        mascotas.add(new Mascota("Gurdo", R.drawable.mascotas5, 12));
        mascotas.add(new Mascota("Shaske", R.drawable.mascotas6, 4));
        mascotas.add(new Mascota("Santa", R.drawable.mascotas7, 6));
        mascotas.add(new Mascota("Ace", R.drawable.mascotas8, 7));
        mascotas.add(new Mascota("Pirulin", R.drawable.mascotas9, 3));
        mascotas.add(new Mascota("Conan", R.drawable.mascotas10, 8));
    }
    // inicializar adaptador
    public void inicializarAdaptador(){
        RVAdapter mascotaAdaptador = new RVAdapter(mascotas, getActivity());
        rv_mascotas.setAdapter(mascotaAdaptador);
    }
}
