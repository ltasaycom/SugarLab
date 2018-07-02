package com.example.katherine.sugarlab.repositories;

import com.example.katherine.sugarlab.models.User;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User getUser(String username)
    {
        List<User> users = SugarRecord.listAll(User.class);
        for (User user:users)
        {
            if (user.getUsuario().equalsIgnoreCase(username))
            {
                return user;
            }
        }
        return null;
    }

    public static User login(String username, String password){
        List<User> users = SugarRecord.listAll(User.class);
        for (User user : users){
            if(user.getUsuario().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static void create(String usuario, String fullname, String email, String password){
        User user = new User(usuario, fullname, email,password);
        SugarRecord.save(user);
    }

}
