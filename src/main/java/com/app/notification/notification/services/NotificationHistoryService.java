package com.app.notification.notification.services;

import com.app.notification.notification.model.NotificationHistory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * NotificationHistoryService interface for Notification logs management
 **/
@Service
public interface NotificationHistoryService {


    /**
     * find if the given notification is already sent to user
     **/
    public Optional<NotificationHistory> findByNotificationDataIdAndUserId(int notificationId ,int userId);

    /**
     * Create a new notification history logs for given notification fot the particular user
     * */
    public NotificationHistory createNotificationHistory(int notificationId,int userId);
}
