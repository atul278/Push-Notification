package com.app.notification.notification.services;

import com.app.notification.notification.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public Optional<User> findUserById(int userId);
    public List<User> findUserUserGroupId(int userGroupId);
    public User createUser(User user);
    public List<User> getAllUsers();


}
