package com.app.notification.notification.services;

import com.app.notification.notification.model.NotificationHistory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface NotificationHistoryService {

    public Optional<NotificationHistory> findByNotificationDataIdAndUserId(int notificationId ,int userId);
    public NotificationHistory createNotificationHistory(int notificationId,int userId);
}
