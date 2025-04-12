package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.Notifications;
import com.ustg.FTWA.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Notifications> getAll(){
    	return notificationsRepository.findAll();
    }

    public void markAsRead(Long id) {
        Notifications n = notificationsRepository.findById(id).orElseThrow();
        n.setRead(true);
        notificationsRepository.save(n);
    }
}
