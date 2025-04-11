package com.ustg.notifications.repository;

import com.ustg.notifications.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    List<Notifications> findByUsername(String username);
}
