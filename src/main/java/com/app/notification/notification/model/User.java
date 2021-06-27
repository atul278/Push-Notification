package com.app.notification.notification.model;

import lombok.Data;

import java.beans.Transient;
import java.util.List;

@Data
public class User {
    int id;
    String name;
    String email;
    boolean isGroup;

    // Transient field
    List<Device> devices;
}
