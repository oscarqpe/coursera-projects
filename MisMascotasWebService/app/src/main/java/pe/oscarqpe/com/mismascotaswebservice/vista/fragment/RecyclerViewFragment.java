package pe.oscarqpe.com.mismascotaswebservice.vista.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;
import pe.oscarqpe.com.mismascotaswebservice.R;
import pe.oscarqpe.com.mismascotaswebservice.adapter.RVAdapter;
import pe.oscarqpe.com.mismascotaswebservice.presentador.IRecylerViewFragmentPresenter;
import pe.oscarqpe.com.mismascotaswebservice.presentador.RecyclerViewFragmentPresenter;

/**
 * Created by oscarqpe on 22/07/17.
 */

public class RecyclerViewFragment extends Fragment implements  IRecyclerViewFragmentView {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;
    private IRecylerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rv_mascotas = (RecyclerView) v.findViewById(R.id.rv_mascotas);
        presenter = new RecyclerViewFragmentPresenter(this, this.getContext());

        return v;
    }
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(llm);

    }

    @Override
    public RVAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        System.out.println("Mascotas: " + mascotas);
        RVAdapter adaptador = new RVAdapter(mascotas, getActivity());
        System.out.println(adaptador);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(RVAdapter adaptador) {
        System.out.println("Adaptador: " + adaptador);
        rv_mascotas.setAdapter(adaptador);
        System.out.println("Adaptador: " + rv_mascotas);
    }
}
