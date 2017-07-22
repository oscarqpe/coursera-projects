package pe.oscarqpe.com.mismascotas;

/**
 * Created by oscarqpe on 22/07/17.
 */

public class Mascota {
    private String nombre;
    private int foto;
    private int likes;

    public Mascota(String nombre, int foto, int likes) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
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
}
