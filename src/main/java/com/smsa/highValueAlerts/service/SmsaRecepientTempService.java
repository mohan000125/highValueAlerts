package com.smsa.highValueAlerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsa.highValueAlerts.DTO.RecepientDTO;
import com.smsa.highValueAlerts.entity.SmsaRecepientMaster;
import com.smsa.highValueAlerts.entity.SmsaRecepientTemp;
import com.smsa.highValueAlerts.repository.RecepientMasterRepo;
import com.smsa.highValueAlerts.repository.RecepientTempRepo;
import java.util.List;

import java.util.Optional;

@Service
public class SmsaRecepientTempService {

    @Autowired
    private RecepientTempRepo recepientTempRepo;

    @Autowired
    private RecepientMasterRepo recepientMasterRepo;

    public String addRecepientTempData(RecepientDTO recepientDTO) {

        // Check uniqueness of the 4-column combination
        boolean existsInMs = recepientMasterRepo.existsByUniqueCombo(
                recepientDTO.getSmsaEmpId(),
                recepientDTO.getSmsaGeoName(),
                recepientDTO.getSmsaSenderBic(),
                recepientDTO.getSmsaMsgType()
        );

        if (existsInMs) {
            return String.format(
                    "Recipient already exists in masterTable with EmpId = '%s', GeoName = '%s', SenderBIC = '%s', MsgType = '%s'.",
                    recepientDTO.getSmsaEmpId(),
                    recepientDTO.getSmsaGeoName(),
                    recepientDTO.getSmsaSenderBic(),
                    recepientDTO.getSmsaMsgType()
            );
        }
        boolean existsTemp = recepientTempRepo.existsByUniqueCombo(
                recepientDTO.getSmsaEmpId(),
                recepientDTO.getSmsaGeoName(),
                recepientDTO.getSmsaSenderBic(),
                recepientDTO.getSmsaMsgType()
        );

        if (existsTemp) {
            return String.format(
                    "Recipient data already waiting for approval with EmpId = '%s', GeoName = '%s', SenderBIC = '%s', MsgType = '%s'.",
                    recepientDTO.getSmsaEmpId(),
                    recepientDTO.getSmsaGeoName(),
                    recepientDTO.getSmsaSenderBic(),
                    recepientDTO.getSmsaMsgType()
            );
        }

        // Proceed with insert
        SmsaRecepientTemp smsaRecepientTemp = buildPojoToEntityCombo(recepientDTO);
        recepientTempRepo.save(smsaRecepientTemp);

        return "Recipient added successfully and went for approval";
    }

    public String updateRecieptData(RecepientDTO recepientDTO) {
        if (recepientDTO.getSmsaRamId() != null) {
            boolean existsInMs = recepientMasterRepo.existsByUniqueCombo(
                    recepientDTO.getSmsaEmpId(),
                    recepientDTO.getSmsaGeoName(),
                    recepientDTO.getSmsaSenderBic(),
                    recepientDTO.getSmsaMsgType()
            );
            boolean existsTemp = recepientTempRepo.existsByUniqueCombo(
                    recepientDTO.getSmsaEmpId(),
                    recepientDTO.getSmsaGeoName(),
                    recepientDTO.getSmsaSenderBic(),
                    recepientDTO.getSmsaMsgType()
            );

            if (existsInMs || existsTemp) {
                SmsaRecepientTemp smsaRecepientTemp = buildPojoToEntityCombo(recepientDTO);
                recepientTempRepo.save(smsaRecepientTemp);
                return "Updated Successfully ,Went for approval";
            }
        }
        return "Id not found to update";
    }

    public String deleteRecepientByEmpId(Long smsaRamId) {
        if (smsaRamId == null) {
            return "smsaRamId must not be null";
        }

        Optional<SmsaRecepientMaster> existing = recepientMasterRepo.findById(smsaRamId);
        if (existing.isPresent()) {
            recepientTempRepo.deleteBySmsaRamId(smsaRamId);
            return "Recipient deleted successfully";
        } else {
            return "Recipient with smsaRamId " + smsaRamId + " not found";
        }
    }

    public List<SmsaRecepientTemp> getRecepientData() {
        List<SmsaRecepientTemp> s= recepientTempRepo.findAll();
        return s;
    }

    public SmsaRecepientTemp buildPojoToEntityCombo(RecepientDTO recepientDTO) {
        SmsaRecepientTemp smsaRecepientTemp = new SmsaRecepientTemp();

        smsaRecepientTemp.setSmsaRamId(recepientDTO.getSmsaRamId() != null ? recepientDTO.getSmsaRamId() : null);
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
        return smsaRecepientTemp;
    }

}
