package com.smsa.highValueAlerts.controller;

import com.smsa.highValueAlerts.DTO.ReciepientRequestDto;
import com.smsa.highValueAlerts.service.SmsaRecepientTempService;
import java.util.Map;
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
                String msg = smsaRecepientTempService.addRecepientTempData(reciepientRequestDto.getRecepientDTO());
                return ResponseEntity.ok(msg);
            case "UPDATE":

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

//    @PostMapping("/recipient/fetchData")
//    public ResponseEntity<?> getRecipientTempData(@RequestBody Map<String, String> tokenMap) {
//        
//    }

    @GetMapping("/")
    String getData() {
        return "High Value Alerts Deployed Successfully";
    }

}
