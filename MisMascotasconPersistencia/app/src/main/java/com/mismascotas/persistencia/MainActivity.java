package com.mismascotas.persistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mismascotas.persistencia.model.Mascota;
import com.mismascotas.persistencia.views.RecyclerViewImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mi_tool_bar = (Toolbar) findViewById(R.id.mi_bar);
        setSupportActionBar(mi_tool_bar);

        RecyclerViewImpl rv = new RecyclerViewImpl(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_favoritos:
                Intent intent = new Intent(MainActivity.this, MiFavoritos.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
