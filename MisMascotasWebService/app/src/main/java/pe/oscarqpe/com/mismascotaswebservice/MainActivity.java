package pe.oscarqpe.com.mismascotaswebservice;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.adapter.PageAdapter;
import pe.oscarqpe.com.mismascotaswebservice.vista.fragment.PerfilFragment;
import pe.oscarqpe.com.mismascotaswebservice.vista.fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tab_layout;
    private ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        setUpViewPager();
        Toolbar mi_tool_bar = (Toolbar) findViewById(R.id.mi_bar);
        setSupportActionBar(mi_tool_bar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments () {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager() {
        view_pager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tab_layout.setupWithViewPager(view_pager);

        tab_layout.getTabAt(0).setIcon(R.drawable.ic_home);
        tab_layout.getTabAt(1).setIcon(R.drawable.ic_dog);
        TabLayout.Tab tab = tab_layout.getTabAt(1);
        tab.select();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_favoritos:
                Intent intent = new Intent(MainActivity.this, MiFavoritos.class);
                startActivity(intent);
                break;
            case R.id.menu_contacto:
                Intent intent1 = new Intent(this, Contacto.class);
                startActivity(intent1);
                break;
            case R.id.menu_acerca_de:
                Intent intent2 = new Intent(this, About.class);
                startActivity(intent2);
                break;
            case R.id.menu_configurar:
                Intent intent3 = new Intent(this, Configurar.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
}
