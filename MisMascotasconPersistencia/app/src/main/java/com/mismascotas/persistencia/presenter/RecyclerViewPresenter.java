package com.mismascotas.persistencia.presenter;

import android.content.Context;

import com.mismascotas.persistencia.model.ConstructorMascota;
import com.mismascotas.persistencia.model.Mascota;
import com.mismascotas.persistencia.views.IRecyclerView;

import java.util.ArrayList;

/**
 * Created by oscarqpe on 29/07/17.
 */

public class RecyclerViewPresenter implements IRecylerViewPresenter {
    private IRecyclerView iRecyclerView;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public  RecyclerViewPresenter(IRecyclerView iRecyclerView, Context context) {
        this.context = context;
        this.iRecyclerView = iRecyclerView;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascota = new ConstructorMascota(context);
        mascotas = constructorMascota.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerView.inicializarAdaptadorRV(iRecyclerView.crearAdaptador(mascotas));
        iRecyclerView.generarLinearLayoutVertical();
    }
}
