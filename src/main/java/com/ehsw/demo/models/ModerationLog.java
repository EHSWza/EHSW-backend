package com.ehsw.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "moderation_log")
public class ModerationLog {
    @Id
    @Column(name = "log_id", nullable = false)
    private UUID log_id;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Reports report_id;

    @ManyToOne
    @JoinColumn(name = "dispute_id")
    private DriverDisputes dispute_id;

    @ManyToOne
    @JoinColumn(name = "moderator_id")
    private Users moderator_id;

    @Column(name = "action")
    private String action;

    @Column(name = "comments")
    private String comments;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
