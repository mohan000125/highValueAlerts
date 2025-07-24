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

    public String addRecepientTempData(RecepientDTO recepientDTO) {

    // Check uniqueness of the 4-column combination
    boolean exists = recepientTempRepo.existsByUniqueCombo(
        recepientDTO.getSmsaEmpId(),
        recepientDTO.getSmsaGeoName(),
        recepientDTO.getSmsaSenderBic(),
        recepientDTO.getSmsaMsgType()
    );

    if (exists) {
    return String.format(
        "Recipient already exists with EmpId = '%s', GeoName = '%s', SenderBIC = '%s', MsgType = '%s'.",
        recepientDTO.getSmsaEmpId(),
        recepientDTO.getSmsaGeoName(),
        recepientDTO.getSmsaSenderBic(),
        recepientDTO.getSmsaMsgType()
    );
    }


    // Proceed with insert
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

    recepientTempRepo.save(smsaRecepientTemp);

    return "Recipient added successfully";
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
