package pe.oscarqpe.com.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        Bundle parametros = getIntent().getExtras();
        final String nombre_completo = parametros.getString("nombre_completo");
        final String fecha_nacimiento = parametros.getString("fecha_nacimiento");
        final String telefono = parametros.getString("telefono");
        final String email = parametros.getString("email");
        final String descripcion = parametros.getString("descripcion");

        TextView tvNombreCompleto = (TextView) findViewById(R.id.tvNombreCompleto);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        tvNombreCompleto.setText("NOMBRE COMPLETO: " + nombre_completo);
        tvFechaNacimiento.setText("FECHA NACIMIENTO: " + fecha_nacimiento);
        tvTelefono.setText("TELÉFONO: " + telefono);
        tvEmail.setText("EMAIL: " + email);
        tvDescripcion.setText("DESCRIPCIÓN: " + descripcion);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra("nombre_completo", nombre_completo);
                intent.putExtra("fecha_nacimiento", fecha_nacimiento);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
                startActivity(intent);
            }
        });
    }
}
