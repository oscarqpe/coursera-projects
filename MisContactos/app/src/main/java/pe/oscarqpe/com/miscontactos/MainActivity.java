package pe.oscarqpe.com.miscontactos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Calendar calendar = Calendar.getInstance();
    TextInputEditText nombre_completo;
    TextInputEditText fecha_nacimiento;
    TextInputEditText telefono;
    TextInputEditText email;
    TextInputEditText descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre_completo     = (TextInputEditText) findViewById(R.id.nombre_completo);
        fecha_nacimiento    = (TextInputEditText) findViewById(R.id.fecha_nacimiento);
        telefono            = (TextInputEditText) findViewById(R.id.telefono);
        email               = (TextInputEditText) findViewById(R.id.email);
        descripcion         = (TextInputEditText) findViewById(R.id.descripcion);
        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        if (getIntent().hasExtra("nombre_completo")
                && getIntent().hasExtra("fecha_nacimiento")
                && getIntent().hasExtra("telefono")
                && getIntent().hasExtra("email")
                && getIntent().hasExtra("descripcion")) {
            Bundle parametros = getIntent().getExtras();
            final String p_nombre_completo = parametros.containsKey("nombre_completo") ? parametros.getString("nombre_completo") : "";
            final String p_fecha_nacimiento = parametros.containsKey("fecha_nacimiento") ? parametros.getString("fecha_nacimiento") : "";
            final String p_telefono = parametros.containsKey("telefono") ? parametros.getString("telefono") : "";
            final String p_email = parametros.containsKey("email") ? parametros.getString("email") : "";
            final String p_descripcion = parametros.containsKey("descripcion") ? parametros.getString("descripcion") : "";


            nombre_completo.setText(p_nombre_completo);
            fecha_nacimiento.setText(p_fecha_nacimiento);
            telefono.setText(p_telefono);
            email.setText(p_email);
            descripcion.setText(p_descripcion);
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                Contacto contacto = new Contacto();
                contacto.setNombreCompleto(nombre_completo.getText().toString());
                contacto.setFechaNacimiento(fecha_nacimiento.getText().toString());
                contacto.setTelefono(telefono.getText().toString());
                contacto.setEmail(email.getText().toString());
                contacto.setDescripcion(descripcion.getText().toString());
                intent.putExtra("nombre_completo", contacto.getNombreCompleto());
                intent.putExtra("fecha_nacimiento", contacto.getFechaNacimiento());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                intent.putExtra("descripcion", contacto.getDescripcion());
                startActivity(intent);
            }
        });
        fecha_nacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }
    public void showDatePickerDialog() {
        int year = 0;
        int month = 0;
        int day = 0;
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        if (!fecha_nacimiento.getText().toString().equals("")) {
            try {
                calendar.setTime(sdf.parse(fecha_nacimiento.getText().toString()));
                year = calendar.YEAR;
                month = calendar.MONTH;
                day = calendar.DAY_OF_MONTH;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            year = Calendar.YEAR;
            month = Calendar.MONTH;
            day = Calendar.DAY_OF_MONTH;
        }
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                fecha_nacimiento.setText(sdf.format(calendar.getTime()));
                telefono.requestFocus();
            }
        }, calendar.get(year), calendar.get(month), calendar.get(day)
        );
        dialog.show();
    }
}
