package com.mismascotas.persistencia.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mismascotas.persistencia.R;
import com.mismascotas.persistencia.adapter.RVAdapter;
import com.mismascotas.persistencia.model.Mascota;
import com.mismascotas.persistencia.presenter.IRecylerViewPresenter;
import com.mismascotas.persistencia.presenter.RecyclerViewPresenter;

import java.util.ArrayList;

/**
 * Created by oscarqpe on 29/07/17.
 */

public class RecyclerViewImpl implements IRecyclerView {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;
    private IRecylerViewPresenter presenter;
    private Activity activity;
    public RecyclerViewImpl(Activity activity) {
        this.activity = activity;
        rv_mascotas = (RecyclerView) activity.findViewById(R.id.rv_mascotas);
        presenter = new RecyclerViewPresenter(this, activity);
    }
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(activity);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(llm);
    }

    @Override
    public RVAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        System.out.println("Mascotas: " + mascotas);
        RVAdapter adaptador = new RVAdapter(mascotas, activity);
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
