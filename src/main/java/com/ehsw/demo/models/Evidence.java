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
    private UUID evidence_id;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Reports report_id;


    @Column(name = "file_url", nullable = false)
    private String file_url;

    @Column(name = "description")
    private String description;

    @Column(name = "category", length = 20)
    private String category;

    @Column(name = "uploaded_at")
    private LocalDateTime uploaded_at;
}
