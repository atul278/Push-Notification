package com.app.notification.notification.controllers;

import com.app.notification.notification.model.Notification;
import com.app.notification.notification.model.User;
import com.app.notification.notification.services.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 * Controller to add CRUD opertions and push notification
 *
 * */
@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/notify-user")
    public List<Map<String, Object>> notifyUser(@RequestBody Map<String,Object> requestBody){
        return notificationService.sendNotification( (int) requestBody.get("notificationId"), (int) requestBody.get("userId"));
    }

    @PostMapping("")
    public Notification createNotification(@RequestBody Notification notification){
        return notificationService.createNotification(notification);
    }

    @GetMapping()
    public List<Notification> getAllNotifications(){
        return notificationService.getAllNotifications();
    }

}
