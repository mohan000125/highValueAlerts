package com.smsa.highValueAlerts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsaHighValueAlertsController {

    @GetMapping("/")
    String getData(){
        return "Hello world";
    }


}
