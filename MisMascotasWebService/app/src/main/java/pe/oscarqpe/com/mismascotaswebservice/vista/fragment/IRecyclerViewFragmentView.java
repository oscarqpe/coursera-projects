package pe.oscarqpe.com.mismascotaswebservice.vista.fragment;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.adapter.RVAdapter;
import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;

/**
 * Created by oscarqpe on 23/07/17.
 */

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();

    public RVAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(RVAdapter adaptador);
}
