package com.ustg.notifications.controller;

import com.ustg.notifications.entity.*;
import com.ustg.notifications.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @PostMapping
    public Notifications create(@RequestBody Notifications notifications ) {
        return notificationsService.createNotifications(notifications);
    }

    @GetMapping("/{username}")
    public List<Notifications> getByUser(@PathVariable String username) {
        return notificationsService.getUserNotifications(username);
    }

    @PutMapping("/{id}/read")
    public void markAsRead(@PathVariable Long id) {
        notificationsService.markAsRead(id);
    }
}
