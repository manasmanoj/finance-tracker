package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.Goal;
import com.ustg.FTWA.entity.Notifications;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.GoalRepository;
import com.ustg.FTWA.repository.NotificationsRepository;
import com.ustg.FTWA.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GoalRepository goalRepository;

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
        User user = userRepository.findById(notification.getUser().getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Goal goal = goalRepository.findById(notification.getGoal().getId())
                .orElseThrow(() -> new RuntimeException("Goal not found"));

        notification.setUser(user);
        notification.setGoal(goal);

        return notificationsRepository.save(notification);
    }

    public void sendNotification(User user, String message, Goal goal) {
        Notifications notification = new Notifications();
        notification.setUser(user);
        notification.setGoal(goal);
        notification.setMessage(message);
        notification.setRead(false);
        notification.setCreatedAt(LocalDate.now());

        notificationsRepository.save(notification);
    }
}
