package com.app.notification.notification.services;

import com.app.notification.notification.model.Notification;
import com.app.notification.notification.model.User;

import java.util.*;

/**
 * NotificationService interface for device management
 *
 * */
public interface NotificationService {


    /**
     * Sends particular notification to given user_id
     * */
    public List<Map<String, Object>> sendNotification(int notificationId, int userId);

    /**
     * Verifies the notification history and sends notification to particular user
     * */
    public Map<String, Object> verifyAndSendNotification(int notificationId, User user);

    /**
     * Create new notification
     * */
    public Notification createNotification(Notification notification);

    /**
     * fetches all the notification in the system
     * */
    public List<Notification> getAllNotifications();

}
