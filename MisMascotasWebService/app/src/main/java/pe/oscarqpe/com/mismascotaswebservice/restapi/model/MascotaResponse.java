package pe.oscarqpe.com.mismascotaswebservice.restapi.model;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class MascotaResponse {
    private ArrayList<Mascota> mascotas = null;

    public ArrayList<Mascota> getMascotas() {
        return this.mascotas;
    }

    public void setContactos(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
