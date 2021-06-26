package com.app.notification.notification.services.impl;

import com.app.notification.notification.model.NotificationHistory;
import com.app.notification.notification.services.NotificationHistoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationHistoryServiceImpl implements NotificationHistoryService {

    Integer notificationId=1;

    List<NotificationHistory> notificationHistoryList= new ArrayList<>();

    public Optional<NotificationHistory> findByNotificationDataIdAndUserId(int notificationId , int userId){
        return notificationHistoryList.stream().filter(t->t.getUserId()==userId && t.getNotificationId()==notificationId).findAny();
    }

    public NotificationHistory createNotificationHistory(int notificationId,int userId){
        NotificationHistory notificationHistory = new NotificationHistory();
        notificationHistory.setId(this.notificationId);
        notificationHistory.setNotificationId(notificationId);
        notificationHistory.setUserId(userId);
        this.notificationId++;
        notificationHistoryList.add(notificationHistory);
        return notificationHistory;
    }
}
