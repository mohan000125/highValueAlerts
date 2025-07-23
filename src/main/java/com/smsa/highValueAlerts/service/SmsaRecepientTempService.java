package com.smsa.highValueAlerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsa.highValueAlerts.DTO.RecepientDTO;
import com.smsa.highValueAlerts.entity.SmsaRecepientTemp;
import com.smsa.highValueAlerts.repository.RecepientTempRepo;

import java.util.Optional;

@Service
public class SmsaRecepientTempService {

    @Autowired
    private RecepientTempRepo recepientTempRepo;

    public String addAndUpdateRecepientTempData(RecepientDTO recepientDTO) {

        // Validate if ID is provided
        String id = recepientDTO.getSmsaEmpId();

        SmsaRecepientTemp smsaRecepientTemp = new SmsaRecepientTemp();

        smsaRecepientTemp.setSmsaRamId(recepientDTO.getSmsaRamId());
        smsaRecepientTemp.setSmsaEmpId(recepientDTO.getSmsaEmpId());
        smsaRecepientTemp.setSmsaGeoName(recepientDTO.getSmsaGeoName());
        smsaRecepientTemp.setSmsaSenderBic(recepientDTO.getSmsaSenderBic());
        smsaRecepientTemp.setSmsaMsgType(recepientDTO.getSmsaMsgType());
        smsaRecepientTemp.setSmsaEmpName(recepientDTO.getSmsaEmpName());
        smsaRecepientTemp.setSmsaGrade(recepientDTO.getSmsaGrade());
        smsaRecepientTemp.setSmsaCreatedBy(recepientDTO.getSmsaCreatedBy());
        smsaRecepientTemp.setSmsaModifiedBy(recepientDTO.getSmsaModifiedBy());
        smsaRecepientTemp.setSmsaModifiedDate(recepientDTO.getSmsaModifiedDate());
        smsaRecepientTemp.setSmsaVerifiedBy(recepientDTO.getSmsaVerifiedBy());
        smsaRecepientTemp.setSmsaVerifiedDate(recepientDTO.getSmsaVerifiedDate());
        smsaRecepientTemp.setSmsaAction(recepientDTO.getSmsaAction());

        if (id != null) {
            Optional<SmsaRecepientTemp> data = recepientTempRepo.findBySmsaEmpId(id);

            if (data.isPresent()) {
                // If exists, update the existing record
                SmsaRecepientTemp existing = data.get();

                existing.setSmsaRamId(smsaRecepientTemp.getSmsaRamId());
                existing.setSmsaEmpId(smsaRecepientTemp.getSmsaEmpId());
                existing.setSmsaGeoName(smsaRecepientTemp.getSmsaGeoName());
                existing.setSmsaSenderBic(smsaRecepientTemp.getSmsaSenderBic());
                existing.setSmsaMsgType(smsaRecepientTemp.getSmsaMsgType());
                existing.setSmsaEmpName(smsaRecepientTemp.getSmsaEmpName());
                existing.setSmsaGrade(smsaRecepientTemp.getSmsaGrade());
                existing.setSmsaCreatedBy(smsaRecepientTemp.getSmsaCreatedBy());
                existing.setSmsaModifiedBy(smsaRecepientTemp.getSmsaModifiedBy());
                existing.setSmsaModifiedDate(smsaRecepientTemp.getSmsaModifiedDate());
                existing.setSmsaVerifiedBy(smsaRecepientTemp.getSmsaVerifiedBy());
                existing.setSmsaVerifiedDate(smsaRecepientTemp.getSmsaVerifiedDate());
                existing.setSmsaAction(smsaRecepientTemp.getSmsaAction());

                recepientTempRepo.save(existing);
                return "Recipient updated successfully";
            }
            // If ID is null or not found, insert new
            recepientTempRepo.save(smsaRecepientTemp);
            return "Recipient added successfully";
        }
        return "Please enter EMP ID";
    }

    public String deleteRecepientByEmpId(Long smsaRamId) {
        if (smsaRamId == null) {
            return "smsaRamId must not be null";
        }

        Optional<SmsaRecepientTemp> existing = recepientTempRepo.findById(smsaRamId);
        if (existing.isPresent()) {
            recepientTempRepo.deleteBySmsaRamId(smsaRamId);
            return "Recipient deleted successfully";
        } else {
            return "Recipient with smsaRamId " + smsaRamId + " not found";
        }
    }

}
