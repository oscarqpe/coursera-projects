package com.mismascotas.persistencia.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mismascotas.persistencia.model.Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by oscarqpe on 29/07/17.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS + "(" +
                ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_PETS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PET + "(" +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + "(" + ConstantesBaseDatos.TABLE_PETS_ID + ")" +
                ")";
        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_PET);
        db.execSQL("DROP TABLE IF EXIST usuarios");
        onCreate(db);
    }
    public String insertUsuario(String usuario) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", "1");
        contentValues.put("usuario", usuario);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("usuarios",null, contentValues);
        db.close();
        return usuario;
    }

    public ArrayList<Mascota> obtenerMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES+") as likes " +
                                " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }
    public ArrayList<Mascota> misFavoritos(int rows) {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "select " +
                        "m.*, " +
                        "( " +
                            "select " +
                                " count(l.id) " +
                            "from mascota_likes l " +
                            "where l.id_mascota = m.id " +
                            ") as likes " +
                        "from mascota m order by likes desc limit 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setLikes(registros.getInt(3));
            mascotas.add(mascotaActual);
            Log.d("MAscota: ", mascotaActual.toString());
        }

        db.close();
        System.out.println("Size MAscotas: " + mascotas.size());
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS,null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_PET, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
