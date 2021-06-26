package com.app.notification.notification.model;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    String email;
    boolean isGroup;
}
