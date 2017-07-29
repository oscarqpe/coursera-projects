package com.mismascotas.persistencia.views;

import com.mismascotas.persistencia.adapter.RVAdapter;
import com.mismascotas.persistencia.model.Mascota;

import java.util.ArrayList;

/**
 * Created by oscarqpe on 29/07/17.
 */

public interface IRecyclerView {
    public void generarLinearLayoutVertical();

    public RVAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(RVAdapter adaptador);
}
