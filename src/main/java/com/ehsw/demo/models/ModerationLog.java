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
    private UUID logId;

    @JoinColumn(name = "report_id")
    private UUID reportId;

    @JoinColumn(name = "dispute_id")
    private UUID disputeId;

    @JoinColumn(name = "moderator_id")
    private UUID moderatorId;

    @Column(name = "action")
    private String action;

    @Column(name = "comments")
    private String comments;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
