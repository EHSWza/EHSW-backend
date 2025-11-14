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
@Table(name = "reports")
public class Reports {
    @Id
    @Column(name = "report_id", nullable = false)
    private UUID report_id;

    @ManyToOne
    @JoinColumn(name = "reporter_id", nullable = false)
    private Users reporter_id;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Users driver_id;

    @Column(name = "platform", nullable = false, length = 50)
    private String platform;

    @Column(name = "trip_id", length = 100)
    private String trip_id;

    @Column(name = "trip_date")
    private LocalDateTime trip_date;

    @Column(name = "pickup_location")
    private String pickup_location;

    @Column(name = "dropoff_location")
    private String dropoff_location;

    @Column(name = "incident_type", nullable = false)
    private List<String> incident_type;

    @Column(name = "incident_description", nullable = false)
    private String incident_description;

    @Column(name = "incident_datetime")
    private LocalDateTime incident_datetime;

    @Column(name = "location_of_incident")
    private String location_of_incident;

    @Column(name = "verification_status", length = 20)
    private String verification_status;

    @Column(name = "moderator_comments")
    private String moderator_comments;

    @Column(name = "ip_address")
    private String ip_address;

    @Column(name = "submitted_at")
    private LocalDateTime submitted_at;

    @Column(name = "last_updated")
    private LocalDateTime last_updated;
}
