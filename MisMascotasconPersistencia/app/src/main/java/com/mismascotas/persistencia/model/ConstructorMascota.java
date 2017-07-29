package com.mismascotas.persistencia.model;

import android.content.ContentValues;
import android.content.Context;

import com.mismascotas.persistencia.R;
import com.mismascotas.persistencia.db.BaseDatos;
import com.mismascotas.persistencia.db.ConstantesBaseDatos;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by oscarqpe on 29/07/17.
 */

public class ConstructorMascota {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        ArrayList<Mascota> mascotas = db.obtenerMascotas();
        if (mascotas.size() > 0)
            return mascotas;
        insertarMascotas(db);
        return  db.obtenerMascotas();
    }
    public ArrayList<Mascota> misFavoritos(int rows) {
        BaseDatos db = new BaseDatos(context);
        ArrayList<Mascota> mascotas = db.misFavoritos(rows);
        return  mascotas;
    }



    public void insertarMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Tobi");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Fido");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Conan");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas3);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Tarzan");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas4);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Rey");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas5);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Archi");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas6);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Jonas");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas7);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Ernesto");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas8);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Ramon");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas9);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Rikun");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.mascotas10);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}