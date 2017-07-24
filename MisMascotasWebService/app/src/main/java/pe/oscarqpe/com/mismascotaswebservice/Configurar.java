package pe.oscarqpe.com.mismascotaswebservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pe.oscarqpe.com.mismascotaswebservice.model.ConstructorUser;
import pe.oscarqpe.com.mismascotaswebservice.model.User;

public class Configurar extends AppCompatActivity {
    TextView tv_usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);
        Toolbar mi_tool_bar = (Toolbar) findViewById(R.id.mi_bar);
        setSupportActionBar(mi_tool_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_usuario = (TextView) findViewById(R.id.tv_usuario);


    }
    void guardarCuenta(View v) {
        String usuario = tv_usuario.getText().toString();
        if (usuario.equals("")) {
            usuario = "perritotobi";
        }
        ConstructorUser constructorUser = new ConstructorUser(v.getContext());
        User user = constructorUser.getCurrentUsuario();
        if (user == null) {
            System.out.println("No Current User");
            usuario = constructorUser.insertUsuario(usuario);
        } else {
            System.out.println("Actualizar usuario");
            user.setUsuario(usuario);
            user = constructorUser.actualizarUsuario(user);
        }
        Toast.makeText(v.getContext(), "Se guardo el nombre de usuario!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
