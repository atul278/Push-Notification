package com.app.notification.notification.services;

import com.app.notification.notification.model.Notification;
import com.app.notification.notification.model.User;

import java.util.*;

public interface NotificationService {

    public List<Map<String, Object>> sendNotification(int notificationId, int userId) ;
    public Map<String, Object> verifyAndSendNotification(int notificationId, User user) ;
    public Notification createNotification(Notification notification);
    public List<Notification> getAllNotifications();

}
