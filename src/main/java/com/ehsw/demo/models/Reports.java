package com.ehsw.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "reports")
public class Reports {
    @Id
    @Column(name = "report_id", nullable = false)
    private UUID reportId;

    @JoinColumn(name = "reporter_id", nullable = false)
    @JsonIgnore
    private UUID reporterId;

    @JoinColumn(name = "driver_id", nullable = false)
    private UUID driverId;

    @Column(name = "platform", nullable = false, length = 50)
    private String platform;

    @Column(name = "trip_date")
    private LocalDateTime tripDate;

    @Column(name = "pickup_location")
    private String pickupLocation;

    @Column(name = "dropoff_location")
    private String dropoffLocation;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @Column(name = "incident_type", nullable = false)
    private List<String> incidentType;

    @Column(name = "incident_description", nullable = false)
    private String incidentDescription;

    @Column(name = "incident_datetime")
    private LocalDateTime incidentDatetime;

    @Column(name = "location_of_incident")
    private String locationOfIncident;

    @Column(name = "verification_status", length = 20)
    private String verificationStatus;

    @Column(name = "moderator_comments")
    private String moderatorComments;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
