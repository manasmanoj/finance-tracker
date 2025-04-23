package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.Notifications;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    public List<Notifications> getUnreadNotifications(User user) {
        return notificationsRepository.findByUserAndIsReadFalse(user);
    }

    public List<Notifications> getAllNotifications(User user) {
        return notificationsRepository.findByUser(user);
    }

    public Notifications markAsRead(Long notificationId) {
        Notifications notification = notificationsRepository.findById(notificationId).orElse(null);
        if (notification != null && !notification.isRead()) {
            notification.setRead(true);
            notificationsRepository.save(notification);
        }
        return notification;
    }

    public Notifications createNotification(Notifications notification) {
        return notificationsRepository.save(notification);
    }
}
