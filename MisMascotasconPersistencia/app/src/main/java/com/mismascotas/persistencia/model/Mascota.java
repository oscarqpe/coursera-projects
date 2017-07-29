package com.mismascotas.persistencia.model;

/**
 * Created by oscarqpe on 22/07/17.
 */

public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int likes;
    public Mascota () {

    }
    public Mascota(int id, String nombre, int foto, int likes) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", foto=" + foto +
                ", likes=" + likes +
                '}';
    }
}
