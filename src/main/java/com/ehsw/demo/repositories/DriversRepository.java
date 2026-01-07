package com.ehsw.demo.repositories;

import com.ehsw.demo.models.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DriversRepository extends JpaRepository<Drivers, UUID> {
    public Drivers findByVehicleNumberPlate(String plate);
}