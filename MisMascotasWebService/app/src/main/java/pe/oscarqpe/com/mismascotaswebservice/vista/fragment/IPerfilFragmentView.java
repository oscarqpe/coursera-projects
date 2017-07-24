package pe.oscarqpe.com.mismascotaswebservice.vista.fragment;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.adapter.RVPAdapter;
import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;

/**
 * Created by oscarqpe on 23/07/17.
 */

public interface IPerfilFragmentView {

    public void generarLinearLayoutVertical();

    public void generarGridLayout();

    public RVPAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRVP(RVPAdapter adaptador);
}
