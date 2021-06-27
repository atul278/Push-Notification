package com.app.notification.notification.model;

import lombok.Data;

import java.util.List;
/**
 * Entity for user, if isGroup is true that the user is a group mail
 *
 * */
@Data
public class User {
    int id;
    String name;
    String email;
    boolean isGroup;

    // Transient field
    List<Device> devices;
}
