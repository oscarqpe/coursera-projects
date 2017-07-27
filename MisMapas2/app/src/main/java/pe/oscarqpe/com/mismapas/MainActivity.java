package pe.oscarqpe.com.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_ubicacion;
    private ArrayList<Ubicacion> ubicaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUbicaciones();
        rv_ubicacion = (RecyclerView) findViewById(R.id.rv_ubicacion);
        RecyclerViewAdapter rva = new RecyclerViewAdapter(ubicaciones, this);
        rv_ubicacion.setAdapter(rva);
        rv_ubicacion.setLayoutManager(new GridLayoutManager(this, 2));
    }
    public void CargarMapa(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void getUbicaciones(){
        ubicaciones = new ArrayList<Ubicacion>();
        ubicaciones.add(new Ubicacion(-16.39836285914041, -71.53673693675536, "Catedral AQP", R.drawable.catedral_aqp, "CATEDRAL"));
        ubicaciones.add(new Ubicacion(-16.41106327737755, -71.52131959933776, "Lambramani", R.drawable.lambramani, "SHOP"));
        ubicaciones.add(new Ubicacion(-16.387267326250033, -71.54244467753905, "Yanahuara", R.drawable.yanahuara, "MIRADOR"));
        ubicaciones.add(new Ubicacion(-16.395295697126514, -71.53674766559142, "Santa Catalina", R.drawable.santa_catalina, "CHURCH"));
    }
}
