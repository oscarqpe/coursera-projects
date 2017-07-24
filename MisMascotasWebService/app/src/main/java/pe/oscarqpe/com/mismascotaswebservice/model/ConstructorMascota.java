package pe.oscarqpe.com.mismascotaswebservice.model;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.R;
import pe.oscarqpe.com.mismascotaswebservice.db.BaseDatos;
import pe.oscarqpe.com.mismascotaswebservice.db.ConstantesBaseDatos;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class ConstructorMascota {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return  db.obtenerTodosLosContactos();
    }



    public void insertarTresMascotas(BaseDatos db){
        /*
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Anahi Salgado");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Anahi Salgado");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Anahi Salgado");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas3);

        db.insertarMascota(contentValues);
        */
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
