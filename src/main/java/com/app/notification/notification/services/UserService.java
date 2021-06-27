package com.app.notification.notification.services;

import com.app.notification.notification.model.User;

import java.util.List;
import java.util.Optional;


/**
 * UserService interface for device management
 *
 * */
public interface UserService {

    /**
     * Finds user by given id
     * */
    public Optional<User> findUserById(int userId);

    /**
     * Finds all users by belonging to given group
     * */
    public List<User> findUserUserGroupId(int userGroupId);

    /**
     * Creates
     * */
    public User createUser(User user);


    /**
     * Finds all users
     * */
    public List<User> getAllUsers();
}
