package com.smsa.highValueAlerts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsa.highValueAlerts.entity.ThresholdTemp;

@Repository
public interface ThresholdTempRepo extends JpaRepository<ThresholdTemp, Long> {
}