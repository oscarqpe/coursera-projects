package pe.oscarqpe.com.mismascotaswebservice.model;

import android.content.Context;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.db.BaseDatos;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class ConstructorUser {
    private Context context;
    public ConstructorUser(Context context) {
        this.context = context;
    }
    public User getCurrentUsuario() {
        BaseDatos db = new BaseDatos(context);
        return  db.getUsuario();
    }
    public  User actualizarUsuario(User user) {
        BaseDatos db = new BaseDatos(context);
        return db.updateUsuario(user);
    }
    public String insertUsuario(String usuario) {
        BaseDatos db = new BaseDatos(context);
        return db.insertUsuario(usuario);
    }
}
