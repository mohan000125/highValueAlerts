package com.smsa.highValueAlerts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsa.highValueAlerts.entity.SmsaRecepientTemp;
import java.util.Optional;

@Repository
public interface RecepientTempRepo extends JpaRepository<SmsaRecepientTemp, Long> {
    // Custom query methods can be added here

    Optional<SmsaRecepientTemp> findBySmsaEmpId(String smsaEmpId);
}
