package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.*;
import com.ustg.FTWA.service.NotificationsService;
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
    
    @GetMapping
    public List<Notifications> getAll(){
    	return notificationsService.getAll();
    	
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
