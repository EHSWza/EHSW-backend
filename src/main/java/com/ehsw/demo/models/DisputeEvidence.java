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
    private UUID disputeEvidenceId;

    @JoinColumn(name = "dispute_id", nullable = false)
    private UUID disputeId;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
}
