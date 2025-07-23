package com.smsa.highValueAlerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsa.highValueAlerts.repository.ThresholdTempRepo;

@Service
public class SmsaThresholdTempService {

    @Autowired
    private ThresholdTempRepo thresholdTempRepo;
    
}
