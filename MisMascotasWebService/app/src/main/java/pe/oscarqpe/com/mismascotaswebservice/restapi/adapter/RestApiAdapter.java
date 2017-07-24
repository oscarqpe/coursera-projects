package pe.oscarqpe.com.mismascotaswebservice.restapi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pe.oscarqpe.com.mismascotaswebservice.model.User;
import pe.oscarqpe.com.mismascotaswebservice.restapi.ConstantesRestApi;
import pe.oscarqpe.com.mismascotaswebservice.restapi.EndpointsApi;
import pe.oscarqpe.com.mismascotaswebservice.restapi.deserializador.MascotaDeserializador;
import pe.oscarqpe.com.mismascotaswebservice.restapi.deserializador.UserDeserializador;
import pe.oscarqpe.com.mismascotaswebservice.restapi.deserializador.UserResponseDeserializador;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.MascotaResponse;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.UserResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class RestApiAdapter {
    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }
    public Gson userDeserializador() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(User.class, new UserDeserializador());
        return gsonBuilder.create();
    }
    public Gson userSearchDeserializador() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserResponse.class, new UserResponseDeserializador());
        return gsonBuilder.create();
    }
}
