package com.ehsw.demo.repositories;

import com.ehsw.demo.models.Drivers;
import com.ehsw.demo.models.Reports;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ReportsRepository extends JpaRepository<Reports, UUID> {
    ArrayList<Reports> findByDriverId(UUID driverId);
}