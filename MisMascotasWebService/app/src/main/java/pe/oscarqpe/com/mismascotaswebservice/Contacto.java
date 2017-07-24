package pe.oscarqpe.com.mismascotaswebservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pe.oscarqpe.com.mismascotaswebservice.util.GMailSender;

public class Contacto extends AppCompatActivity {
    private TextView nombre_completo;
    private TextView email;
    private TextView mensaje;
    private Button btn_enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar mi_tool_bar = (Toolbar) findViewById(R.id.mi_bar);
        setSupportActionBar(mi_tool_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre_completo = (TextView) findViewById(R.id.nombre_completo);
        email = (TextView) findViewById(R.id.email);
        mensaje = (TextView) findViewById(R.id.mensaje);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);

    }
    public void enviarCorreo(View v) {
        try {
            GMailSender sender = new GMailSender("username@gmail.com", "password");
            sender.sendMail("Contacto",
                    nombre_completo.getText().toString()
                           + ", " +
                            email.getText().toString() + ", " + mensaje.getText().toString(),
                    "oscarqpe@gmail.com",
                    "oscarqpe@gmail.com");
            Toast.makeText(v.getContext(), "Mensaje Enviado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
            Toast.makeText(v.getContext(), "Mensaje No Enviado", Toast.LENGTH_SHORT).show();
        }
    }
}
