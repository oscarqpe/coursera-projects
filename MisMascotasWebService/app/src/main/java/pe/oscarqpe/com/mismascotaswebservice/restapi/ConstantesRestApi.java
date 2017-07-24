package pe.oscarqpe.com.mismascotaswebservice.restapi;

/**
 * Created by oscarqpe on 23/07/17.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "5774583149.fecca4d.8c69aa536faf4a8ebe0e2c4c9aa96dd9";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER
            + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/{user-id}/?access_token=ACCESS-TOKEN
    public static final String KEY_GET_USER_INFO = "users/";
    public static final String KEY_SEARCH_USER = "users/search?q=";
}