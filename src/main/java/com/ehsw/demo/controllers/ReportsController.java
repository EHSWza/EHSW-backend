package com.ehsw.demo.controllers;

import com.ehsw.demo.models.Drivers;
import com.ehsw.demo.models.Reports;
import com.ehsw.demo.repositories.DriversRepository;
import com.ehsw.demo.repositories.ReportsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class ReportsController {
    private final ReportsRepository reportsRepository;
    private final DriversRepository driversRepository;

    public ReportsController(ReportsRepository reportsRepository, DriversRepository driversRepository) {
        this.reportsRepository = reportsRepository;
        this.driversRepository = driversRepository;
    }


    @GetMapping("/reports")
    public ResponseEntity<?> getReportsByDriverLicenceNumber(@RequestBody Map<String, String> requestBody) {
        try {
            String numberPlate = requestBody.get("numberPlate");

            if(numberPlate==null){
                return ResponseEntity.badRequest().body("Missing number plate");
            }

            Drivers driver = driversRepository.findByVehicleNumberPlate(numberPlate);

            if(driver==null){
                return ResponseEntity.badRequest().body("Driver not found");
            }

            ArrayList<Reports> reportsList = reportsRepository.findByDriverId(driver.getDriverId());

            if(reportsList==null){
                return ResponseEntity.badRequest().body("Report not found");
            }else{
                return ResponseEntity.ok(reportsList);
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
