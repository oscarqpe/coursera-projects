package pe.oscarqpe.com.mismascotaswebservice.restapi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import pe.oscarqpe.com.mismascotaswebservice.model.User;
import pe.oscarqpe.com.mismascotaswebservice.restapi.JsonKeys;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.MascotaResponse;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class UserDeserializador implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        JsonObject dataResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY);

        String id               = dataResponseData.get(JsonKeys.USER_ID).getAsString();
        String nombreCompleto   = dataResponseData.get(JsonKeys.USER_FULLNAME).getAsString();
        String urlImagen        = dataResponseData.get("profile_picture").getAsString();
        user.setId(id);
        user.setNombreCompleto(nombreCompleto);
        user.setUrlFoto(urlImagen);
        return user;
    }
}
