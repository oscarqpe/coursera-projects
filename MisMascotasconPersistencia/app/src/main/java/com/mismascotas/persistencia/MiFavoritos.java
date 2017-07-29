package com.mismascotas.persistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mismascotas.persistencia.model.Mascota;
import com.mismascotas.persistencia.views.RecyclerViewFavoritosImpl;
import com.mismascotas.persistencia.views.RecyclerViewImpl;

import java.util.ArrayList;

public class MiFavoritos extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_favoritos);
        Toolbar mi_tool_bar = (Toolbar) findViewById(R.id.mi_bar);
        setSupportActionBar(mi_tool_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerViewFavoritosImpl rv = new RecyclerViewFavoritosImpl(this);

    }
}
