package com.ehsw.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @JoinColumn(name = "report_id", nullable = false)
    private UUID reportId;

    @Column(name = "driver_full_name", nullable = false, length = 150)
    private String driverFullName;

    @Column(name = "vehicle_number_plate", nullable = false, length = 20)
    private String vehicleNumberPlate;

    @Column(name = "driver_id_from_platform", length = 100)
    private String driverIdFromPlatform;

    @Column(name = "reason_for_dispute", nullable = false)
    private ArrayList<String> reasonForDispute;

    @Column(name = "driver_explanation", nullable = false)
    private String driverExplanation;

    @Column(name = "moderation_status", length = 20)
    private String moderationStatus;

    @Column(name = "reviewer_comments")
    private String reviewerComments;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
