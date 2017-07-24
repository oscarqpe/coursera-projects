package pe.oscarqpe.com.mismascotaswebservice.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.adapter.RVAdapter;
import pe.oscarqpe.com.mismascotaswebservice.model.ConstructorUser;
import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;
import pe.oscarqpe.com.mismascotaswebservice.R;
import pe.oscarqpe.com.mismascotaswebservice.adapter.RVPAdapter;
import pe.oscarqpe.com.mismascotaswebservice.model.User;
import pe.oscarqpe.com.mismascotaswebservice.presentador.IPerfilFragmentPresenter;
import pe.oscarqpe.com.mismascotaswebservice.presentador.IRecylerViewFragmentPresenter;
import pe.oscarqpe.com.mismascotaswebservice.presentador.PerfilFragmentPresenter;
import pe.oscarqpe.com.mismascotaswebservice.restapi.ConstantesRestApi;
import pe.oscarqpe.com.mismascotaswebservice.restapi.EndpointsApi;
import pe.oscarqpe.com.mismascotaswebservice.restapi.adapter.RestApiAdapter;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.MascotaResponse;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragmentView{

    private ArrayList<Mascota> mascotas;
    private RecyclerView rv_profile_fotos;
    private TextView tv_perfil_nombre;
    private ImageView img_perfil_foto;
    private IPerfilFragmentPresenter presenter;
    private String usuario = "";
    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rv_profile_fotos = (RecyclerView) v.findViewById(R.id.rv_profile_fotos);
        tv_perfil_nombre = (TextView) v.findViewById(R.id.tv_perfil_nombre);
        img_perfil_foto = (ImageView) v.findViewById(R.id.img_perfil_foto);

        presenter = new PerfilFragmentPresenter(this, this.getContext());
        ConstructorUser constructorUser = new ConstructorUser(this.getActivity());
        User user = constructorUser.getCurrentUsuario();
        if (user == null) {
            System.out.println("No Current User");
            usuario = constructorUser.insertUsuario("perritotobi");
        } else {
            System.out.println("Current User");
            usuario = user.getUsuario();
        }
        buscarUsuario(usuario);
        return v;
    }
    void buscarUsuario(String usuario) {
        System.out.println("Current User: " + usuario);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.userSearchDeserializador();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<UserResponse> userCall = endpointsApi.getSearchUser(usuario, ConstantesRestApi.ACCESS_TOKEN);

        userCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                if (userResponse != null)
                    if (userResponse.getUsers().size() > 0) {
                        User user = userResponse.getUsers().get(0);
                        System.out.println(user);
                        Picasso.with(getActivity())
                                .load(user.getUrlFoto())
                                .placeholder(R.drawable.mascotas10)
                                .into(img_perfil_foto);
                        tv_perfil_nombre.setText(user.getNombreCompleto().toString());
                    }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }
    void cargarUsuario() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.userDeserializador();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<User> userCall = endpointsApi.getUserInfo("5774583149");

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                System.out.println(user);
                Picasso.with(getActivity())
                        .load(user.getUrlFoto())
                        .placeholder(R.drawable.mascotas10)
                        .into(img_perfil_foto);
                tv_perfil_nombre.setText(user.getNombreCompleto().toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }
    // inicializar adaptador
    public void inicializarAdaptador(){
        RVPAdapter mascotaAdaptador = new RVPAdapter(mascotas, getActivity());
        rv_profile_fotos.setAdapter(mascotaAdaptador);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_profile_fotos.setLayoutManager(llm);
    }
    @Override
    public  void generarGridLayout() {
        rv_profile_fotos.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }
    @Override
    public RVPAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        RVPAdapter adaptador = new RVPAdapter(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRVP(RVPAdapter adaptador) {
        rv_profile_fotos.setAdapter(adaptador);
    }
}
