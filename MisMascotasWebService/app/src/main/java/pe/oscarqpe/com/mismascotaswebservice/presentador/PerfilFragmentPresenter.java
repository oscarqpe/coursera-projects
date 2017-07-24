package pe.oscarqpe.com.mismascotaswebservice.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.R;
import pe.oscarqpe.com.mismascotaswebservice.model.ConstructorMascota;
import pe.oscarqpe.com.mismascotaswebservice.model.ConstructorUser;
import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;
import pe.oscarqpe.com.mismascotaswebservice.model.User;
import pe.oscarqpe.com.mismascotaswebservice.restapi.ConstantesRestApi;
import pe.oscarqpe.com.mismascotaswebservice.restapi.EndpointsApi;
import pe.oscarqpe.com.mismascotaswebservice.restapi.adapter.RestApiAdapter;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.MascotaResponse;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.UserResponse;
import pe.oscarqpe.com.mismascotaswebservice.vista.fragment.IPerfilFragmentView;
import pe.oscarqpe.com.mismascotaswebservice.vista.fragment.IRecyclerViewFragmentView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {
    private IPerfilFragmentView iPerfilFragmentView;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public  PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        System.out.println("Contex: " + context);
        this.context = context;
        ConstructorUser constructorUser = new ConstructorUser(context);
        User user = constructorUser.getCurrentUsuario();
        String usuario = "";
        if (user == null) {
            System.out.println("No Current User");
            usuario = constructorUser.insertUsuario("perritotobi");
        } else {
            System.out.println("Current User");
            usuario = user.getUsuario();
        }
        buscarUsuario(usuario);
    }
    void buscarUsuario(String usuario) {
        System.out.println("Buscar User: " + usuario);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.userSearchDeserializador();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<UserResponse> userCall = endpointsApi.getSearchUser(usuario, ConstantesRestApi.ACCESS_TOKEN);
        User user = null;
        userCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                if (userResponse != null)
                    if (userResponse.getUsers().size() > 0) {
                        User user = userResponse.getUsers().get(0);
                        obtenerMediosRecientes(user.getId());
                    }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                //Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }
    @Override
    public void obtenerMascotas() {

    }

    @Override
    public void obtenerMediosRecientes(String usuario) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia(usuario);

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                //System.out.print("Size mascotas: " + mascotas.size());
                mostrarMascotasRVP();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotasRVP() {
        iPerfilFragmentView.inicializarAdaptadorRVP(iPerfilFragmentView.crearAdaptador(mascotas));
        iPerfilFragmentView.generarGridLayout();
    }
}
