package pe.oscarqpe.com.mismascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mi_tool_bar = (Toolbar) findViewById(R.id.mi_bar);
        setSupportActionBar(mi_tool_bar);

        rv_mascotas = (RecyclerView)findViewById(R.id.rv_mascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(linearLayoutManager);

        inicializarMascotas();
        inicializarAdaptador();
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
        RVAdapter mascotaAdaptador = new RVAdapter(mascotas, this);
        rv_mascotas.setAdapter(mascotaAdaptador);
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
