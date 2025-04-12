package com.ustg.FTWA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.FTWA.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
