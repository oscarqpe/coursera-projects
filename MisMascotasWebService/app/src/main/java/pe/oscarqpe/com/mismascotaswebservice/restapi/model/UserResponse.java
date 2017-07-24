package pe.oscarqpe.com.mismascotaswebservice.restapi.model;

import java.util.ArrayList;

import pe.oscarqpe.com.mismascotaswebservice.model.User;

/**
 * Created by oscarqpe on 23/07/17.
 */

public class UserResponse {
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
