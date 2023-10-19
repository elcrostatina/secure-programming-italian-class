package com.example.test.user.infrastructure;

import com.example.test.user.application.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByName(String name);

    UserEntity findOneById(UUID id);
}
