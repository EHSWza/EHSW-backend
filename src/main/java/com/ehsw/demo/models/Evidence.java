package com.ehsw.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "evidence")
public class Evidence {
    @Id
    @Column(name = "evidence_id", nullable = false)
    private UUID evidenceId;

    @JoinColumn(name = "report_id")
    private UUID reportId;


    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "category", length = 20)
    private String category;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
}
