package com.smsa.highValueAlerts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsa.highValueAlerts.entity.RecepientTemp;

@Repository
public interface RecepientRepo extends JpaRepository<RecepientTemp, Long> {
    // Custom query methods can be added here
}
