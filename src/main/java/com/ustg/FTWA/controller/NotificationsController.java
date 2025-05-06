package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.Notifications;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @GetMapping("/user/{userId}/unread")
    public List<Notifications> getUnreadNotifications(@PathVariable String userId) {
        User user = new User();
        user.setUsername(userId);
        return notificationsService.getUnreadNotifications(user);
    }

    @GetMapping("/user/{userId}")
    public List<Notifications> getAllNotifications(@PathVariable String userId) {
        User user = new User();
        user.setUsername(userId);
        return notificationsService.getAllNotifications(user);
    }

    @PostMapping
    public Notifications createNotification(@RequestBody Notifications notification) {
        return notificationsService.createNotification(notification);
    }

    @PutMapping("/{id}/read")
    public Notifications markAsRead(@PathVariable Long id) {
        return notificationsService.markAsRead(id);
    }
}
