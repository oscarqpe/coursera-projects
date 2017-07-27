package pe.oscarqpe.com.mismapas;

/**
 * Created by oscarqpe on 27/07/17.
 */

public class Ubicacion {
    private double latitud;
    private double longitud;
    private String nombre;
    private int imagen;
    private String icon;

    public Ubicacion() {
    }

    public Ubicacion(double latitud, double longitud, String nombre, int imagen, String icon) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.nombre = nombre;
        this.imagen = imagen;
        this.icon = icon;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
