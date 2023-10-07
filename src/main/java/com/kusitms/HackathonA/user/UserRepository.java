package com.kusitms.HackathonA.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity, Long> {
    UserEntity findByUserId(Long userId);
}

