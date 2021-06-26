package com.app.notification.notification.services.impl;

import com.app.notification.notification.model.User;
import com.app.notification.notification.model.UserGroup;
import com.app.notification.notification.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList= new ArrayList<>();
    List<UserGroup> userGroupList = new ArrayList<>();
    int userId=1;

    UserServiceImpl(){
        User user = new User();
        user.setEmail("abc@gmail.com");
        user.setId(userId);
        user.setName("Atul");
        user.setGroup(false);
        userList.add(user);
        this.userId++;
    }


    public Optional<User> findUserById(int userId){
        return userList.stream().filter(t->t.getId()==userId).findAny();
    }

    public List<User> findUserUserGroupId(int userGroupId){
        List<Integer> userIds =  new ArrayList<>();
        List<User> userListTmp = new ArrayList<>();

        userGroupList.stream().filter(userGroup->userGroup.getGroupUserId()==userGroupId).forEach(userGroup->userIds.add(userGroup.getUserId()));
        userIds.forEach(userId -> userListTmp.add(findUserById(userId).get()));
        return userListTmp;
    }

    @Override
    public User createUser(User user) {
        user.setId(this.userId);
        this.userId++;
        userList.add(user);
        return  user;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userList;
    }

}
