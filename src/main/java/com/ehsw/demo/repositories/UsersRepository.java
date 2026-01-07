package com.ehsw.demo.repositories;

import com.ehsw.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByGoogleUserId(String googleUserId);
    boolean existsByGoogleUserId(String googleUserId);
}
