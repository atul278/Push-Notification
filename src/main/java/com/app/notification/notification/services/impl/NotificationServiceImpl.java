package com.app.notification.notification.services.impl;

import com.app.notification.notification.model.Notification;
import com.app.notification.notification.model.NotificationHistory;
import com.app.notification.notification.model.User;
import com.app.notification.notification.services.NotificationHistoryService;
import com.app.notification.notification.services.NotificationService;
import com.app.notification.notification.services.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    List<Notification> notificationList = new ArrayList<>();
    int notificationId=1;

    private final UserService userService;
    private final NotificationHistoryService notificationHistoryService;

    public NotificationServiceImpl(UserService userService, NotificationHistoryService notificationHistoryService) {
        this.userService = userService;
        this.notificationHistoryService = notificationHistoryService;

        Notification notification=  new Notification();
        notification.setId(notificationId);
        notification.setData("Notification Mesaage");
        notification.setPriority(0);
        notification.setType("email");

        this.notificationId++;
        notificationList.add(notification);

    }

    @Override
    public List<Map<String, Object>> sendNotification(int notificationId, int userId) {
        Optional<User> userOptional = userService.findUserById(userId);

        List<Map<String, Object>> response = new ArrayList<>();

        if (userOptional.get().isGroup()) {
            List<User> users = userService.findUserUserGroupId(userId);
            users.forEach(userChild -> response.add(verifyAndSendNotification(notificationId, userChild)));
        } else {
            response.add(verifyAndSendNotification(notificationId, userOptional.get()));
        }
        return response;
    }


    @Override
    public Map<String, Object> verifyAndSendNotification(int notificationId, User user) {

        Map<String, Object> response = new HashMap<>();
        Optional<NotificationHistory> notificationHistoryOptional = notificationHistoryService.findByNotificationDataIdAndUserId(notificationId, user.getId());

        List<Notification> notificationList = findNotificationById(notificationId);
        if (notificationList.size()==0){
            response.put("message", "No Notification found");
            return response;
        }

        if (notificationList.size()>1){
            response.put("message", "More than One Notification found ");
            return response;
        }

        if (notificationHistoryOptional.isPresent()) {
            response.put("message", "Notification Already Sent");
            return response;

        } else {

            Notification notification = notificationList.get(0);

            //  External notification Integration with  notification.getData() and user and get devices from List

            NotificationHistory notificationHistory =notificationHistoryService.createNotificationHistory(notificationId,user.getId());
            response.put("data",notification.getData());

        }

        return response;

    }

    @Override
    public Notification createNotification(Notification notification) {
        notification.setId(this.notificationId);
        this.notificationId++;
        notificationList.add(notification);
        return notification;
    }

    @Override
    public List<Notification> getAllNotifications() {
        return this.notificationList;
    }

    private List<Notification> findNotificationById(int notificationId){
        return notificationList.stream().filter(notification -> notification.getId()==notificationId).collect(Collectors.toList());
    }

}
