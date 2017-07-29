package com.mismascotas.persistencia.presenter;

import android.content.Context;

import com.mismascotas.persistencia.model.ConstructorMascota;
import com.mismascotas.persistencia.model.Mascota;
import com.mismascotas.persistencia.views.IRecyclerView;
import com.mismascotas.persistencia.views.IRecyclerViewFavoritos;

import java.util.ArrayList;

/**
 * Created by oscarqpe on 29/07/17.
 */

public class RecyclerViewFavoritosPresenter implements IRecyclerViewFavoritosPresenter {
    private IRecyclerViewFavoritos iRecyclerViewFavoritos;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public  RecyclerViewFavoritosPresenter (IRecyclerViewFavoritos iRecyclerViewFavoritos, Context context) {
        this.context = context;
        this.iRecyclerViewFavoritos = iRecyclerViewFavoritos;
        obtenerMascotasFavoritos();
    }

    @Override
    public void obtenerMascotasFavoritos() {
        constructorMascota = new ConstructorMascota(context);
        mascotas = constructorMascota.misFavoritos(5);
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFavoritos.inicializarAdaptadorRV(iRecyclerViewFavoritos.crearAdaptador(mascotas));
        iRecyclerViewFavoritos.generarLinearLayoutVertical();
    }
}
