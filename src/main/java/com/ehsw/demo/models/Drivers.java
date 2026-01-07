package com.ehsw.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "drivers")
public class Drivers {
    @Id
    @Column(name = "driver_id", nullable = false)
    private UUID driverId;

    @Column(name = "driver_name", nullable = false, length = 150)
    private String driverName;

    @Column(name = "vehicle_number_plate", nullable = false, length = 20)
    private String vehicleNumberPlate;

    @Column(name = "car_model", length = 100)
    private String carModel;

    @Column(name = "platform", nullable = false, length = 50)
    private String platform;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}