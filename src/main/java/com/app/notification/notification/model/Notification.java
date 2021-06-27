package com.app.notification.notification.model;

import lombok.Data;


@Data
public class Notification {
    int id;
    String type;
    int priority;
    String data;

}
