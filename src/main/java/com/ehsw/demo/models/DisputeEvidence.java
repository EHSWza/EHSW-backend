package com.ehsw.demo.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "dispute_evidence")
public class DisputeEvidence {
    @Id
    @Column(name = "dispute_evidence_id", nullable = false)
    private UUID dispute_evidence_id;

    @ManyToOne
    @JoinColumn(name = "dispute_id", nullable = false)
    private DriverDisputes dispute_id;

    @Column(name = "file_url")
    private String file_url;

    @Column(name = "description")
    private String description;

    @Column(name = "uploaded_at")
    private LocalDateTime uploaded_at;
}
