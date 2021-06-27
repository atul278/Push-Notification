package com.app.notification.notification.model;

import lombok.Data;

/**
 * Entity for Notification, le data be the content to send in mail
 *
 * */
@Data
public class Notification {
    int id;
    String type;
    int priority;
    String data;

}
