package com.repository.user;

import com.model.User;

import java.util.HashMap;

public class UserDao {

    private HashMap<Integer, User> userMap = new HashMap<Integer, User>();
    private static UserDao instance;


    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    public User getUser(int userID) {
        return userMap.getOrDefault(userID, null);
    }

    private UserDao() {

    }

    public static synchronized UserDao getInstance() {
        if (instance == null)
            instance = new UserDao();
        return instance;
    }
}
