package com.ustg.FTWA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ustg.FTWA.entity.Notifications;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    List<Notifications> findByUsername(String username);
}
