package com.ehsw.demo.models;

import java.time.LocalDateTime;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "user_id", nullable = false)
    private UUID user_id;

    @Column(name = "google_user_id", length = 100, nullable = false)
    private String google_user_id;

    @Column(name = "role", length = 20)
    private String role;

    @Column(name = "created_at")
    private LocalDateTime created_at;
}
