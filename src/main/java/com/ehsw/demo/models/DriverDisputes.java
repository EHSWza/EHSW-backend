package com.ehsw.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "driver_disputes")
public class DriverDisputes {
    @Id
    @Column(name = "dispute_id", nullable = false)
    private UUID dispute_id;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Reports report_id;

    @Column(name = "driver_full_name", nullable = false, length = 150)
    private String driver_full_name;

    @Column(name = "vehicle_number_plate", nullable = false, length = 20)
    private String vehicle_number_plate;

    @Column(name = "driver_id_from_platform", length = 100)
    private String driver_id_from_platform;

    @Column(name = "reason_for_dispute", nullable = false)
    private List<String> reason_for_dispute;

    @Column(name = "driver_explanation", nullable = false)
    private String driver_explanation;

    @Column(name = "moderation_status", length = 20)
    private String moderation_status;

    @Column(name = "reviewer_comments")
    private String reviewer_comments;

    @Column(name = "submitted_at")
    private LocalDateTime submitted_at;

    @Column(name = "last_updated")
    private LocalDateTime last_updated;
}
