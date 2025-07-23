package com.smsa.highValueAlerts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsa.highValueAlerts.entity.ThresholdMaster;

@Repository
public interface ThresholdMasterRepo extends JpaRepository<ThresholdMaster, Long> {
}
