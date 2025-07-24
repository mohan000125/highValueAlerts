package com.smsa.highValueAlerts.controller;

import com.smsa.highValueAlerts.DTO.ReciepientRequestDto;
import com.smsa.highValueAlerts.service.SmsaRecepientTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsaHighValueAlertsController {

    @Autowired
    SmsaRecepientTempService smsaRecepientTempService;

    @PostMapping("/recipient/actions")
    public ResponseEntity<?> recipientData(@RequestBody ReciepientRequestDto reciepientRequestDto) {
        switch (reciepientRequestDto.getOperation().toUpperCase()) {

            case "ADD":
            case "UPDATE":
                smsaRecepientTempService.addAndUpdateRecepientTempData(reciepientRequestDto.getRecepientDTO());
                return ResponseEntity.ok("Data saved and Went for Approval");

            case "DELETE":
                if (reciepientRequestDto.getRecepientDTO().getSmsaRamId() != null) {
                    smsaRecepientTempService.deleteRecepientByEmpId(reciepientRequestDto.getRecepientDTO().getSmsaRamId());
                    return ResponseEntity.ok("Delete Request Went for approval");
                }
                return ResponseEntity.ok("Id not found to delete");
            default:
                return ResponseEntity.badRequest().body("Invalid operationType: " + reciepientRequestDto.getOperation());

        }
    }

    @GetMapping("/")
    String getData() {
        return "High Value Alerts Deployed Successfully";
    }

}
