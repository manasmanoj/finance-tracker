package com.ustg.FTWA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.FTWA.entity.Notifications;
import com.ustg.FTWA.entity.User;

import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    List<Notifications> findByUserAndIsReadFalse(User user);

    List<Notifications> findByUser(User user);
}
