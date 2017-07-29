package com.mismascotas.persistencia.db;

/**
 * Created by oscarqpe on 29/07/17.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PETS           = "mascota";
    public static final String TABLE_PETS_ID        = "id";
    public static final String TABLE_PETS_NOMBRE    = "nombre";
    public static final String TABLE_PETS_FOTO      = "foto";

    public static final String TABLE_LIKES_PET      = "mascota_likes";
    public static final String TABLE_LIKES_PET_ID   = "id";
    public static final String TABLE_LIKES_PET_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_PET_NUMERO_LIKES = "numero_likes";
}
