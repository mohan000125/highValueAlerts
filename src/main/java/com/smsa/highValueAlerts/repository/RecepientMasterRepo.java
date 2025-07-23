package com.smsa.highValueAlerts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsa.highValueAlerts.entity.RecepientMaster;

@Repository
public interface RecepientMasterRepo extends JpaRepository<RecepientMaster, Long> {
    // Add custom methods if needed
}