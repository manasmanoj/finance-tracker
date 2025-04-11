package com.ustg.notifications.service;

import com.ustg.notifications.entity.*;
import com.ustg.notifications.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    public Notifications createNotifications(Notifications notifications) {
        return notificationsRepository.save(notifications);
    }

    public List<Notifications> getUserNotifications(String username) {
        return notificationsRepository.findByUsername(username);
    }

    public void markAsRead(Long id) {
        Notifications n = notificationsRepository.findById(id).orElseThrow();
        n.setRead(true);
        notificationsRepository.save(n);
    }
}
