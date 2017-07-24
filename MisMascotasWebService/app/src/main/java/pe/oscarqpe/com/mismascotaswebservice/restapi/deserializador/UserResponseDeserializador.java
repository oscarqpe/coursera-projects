package pe.oscarqpe.com.mismascotaswebservice.restapi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.model.Mascota;
import pe.oscarqpe.com.mismascotaswebservice.model.User;
import pe.oscarqpe.com.mismascotaswebservice.restapi.JsonKeys;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.MascotaResponse;
import pe.oscarqpe.com.mismascotaswebservice.restapi.model.UserResponse;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class UserResponseDeserializador implements JsonDeserializer<UserResponse> {
    @Override
    public UserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(json, UserResponse.class);
        JsonArray userResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        userResponse.setUsers(deserializarUserResponseDeJson(userResponseData));
        return userResponse;
    }

    private ArrayList<User> deserializarUserResponseDeJson(JsonArray userResponseData){
        ArrayList<User> users = new ArrayList<>();
        System.out.println("Size data: " + userResponseData.size());
        for (int i = 0; i < userResponseData.size() ; i++) {
            JsonObject userResponseDataObject = userResponseData.get(i).getAsJsonObject();

            String id               = userResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto   = userResponseDataObject.get(JsonKeys.USER_FULLNAME).getAsString();
            String profile_picture   = userResponseDataObject.get(JsonKeys.PROFILE_PICTURE).getAsString();

            User user = new User();
            user.setId(id);
            user.setNombreCompleto(nombreCompleto);
            user.setUrlFoto(profile_picture);

            users.add(user);

        }
        System.out.println("Size mascotas leidas: " + users.size());
        return users;
    }
}
