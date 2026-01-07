package com.ehsw.demo.models;

import java.time.LocalDateTime;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenerationTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "user_id", updatable = false, nullable = false, columnDefinition = "uuid DEFAULT gen_random_uuid()")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT) // Hibernate knows it's DB-generated
    private UUID id;

    @Column(name = "google_user_id", length = 100, nullable = false)
    private String googleUserId;

    @Column(name = "role", length = 20)
    private String role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Users(String google_user_id, String role, LocalDateTime created_at) {
        this.googleUserId = google_user_id;
        this.role = role;
        this.createdAt = created_at;
    }

    public Users() {
    }
}
