package com.app.notification.notification.model;

import lombok.Data;

/**
 * Entity for NotificationHistory, This will the notification sent to a particular user
 *
 * */
@Data
public class NotificationHistory {
    int id;
    int userId;
    int notificationId;
}
