package com.smsa.highValueAlerts.DTO;

import java.time.LocalDateTime;

public class RecepientDTO {

    private Long smsaRamId;

    private String smsaEmpId;

    private String smsaGeoName;

    private String smsaSenderBic;

    private Long smsaMsgType;

    private String smsaEmpName;

    private String smsaGrade;

    private String smsaCreatedBy;

    private String smsaModifiedBy;

    private LocalDateTime smsaModifiedDate;

    private String smsaVerifiedBy;

    private LocalDateTime smsaVerifiedDate;

    private String smsaAction;

    // Getters and Setters

    public Long getSmsaRamId() {
        return smsaRamId;
    }

    public void setSmsaRamId(Long smsaRamId) {
        this.smsaRamId = smsaRamId;
    }

    public String getSmsaEmpId() {
        return smsaEmpId;
    }

    public void setSmsaEmpId(String smsaEmpId) {
        this.smsaEmpId = smsaEmpId;
    }

    public String getSmsaGeoName() {
        return smsaGeoName;
    }

    public void setSmsaGeoName(String smsaGeoName) {
        this.smsaGeoName = smsaGeoName;
    }

    public String getSmsaSenderBic() {
        return smsaSenderBic;
    }

    public void setSmsaSenderBic(String smsaSenderBic) {
        this.smsaSenderBic = smsaSenderBic;
    }

    public Long getSmsaMsgType() {
        return smsaMsgType;
    }

    public void setSmsaMsgType(Long smsaMsgType) {
        this.smsaMsgType = smsaMsgType;
    }

    public String getSmsaEmpName() {
        return smsaEmpName;
    }

    public void setSmsaEmpName(String smsaEmpName) {
        this.smsaEmpName = smsaEmpName;
    }

    public String getSmsaGrade() {
        return smsaGrade;
    }

    public void setSmsaGrade(String smsaGrade) {
        this.smsaGrade = smsaGrade;
    }

    public String getSmsaCreatedBy() {
        return smsaCreatedBy;
    }

    public void setSmsaCreatedBy(String smsaCreatedBy) {
        this.smsaCreatedBy = smsaCreatedBy;
    }

    public String getSmsaModifiedBy() {
        return smsaModifiedBy;
    }

    public void setSmsaModifiedBy(String smsaModifiedBy) {
        this.smsaModifiedBy = smsaModifiedBy;
    }

    public LocalDateTime getSmsaModifiedDate() {
        return smsaModifiedDate;
    }

    public void setSmsaModifiedDate(LocalDateTime smsaModifiedDate) {
        this.smsaModifiedDate = smsaModifiedDate;
    }

    public String getSmsaVerifiedBy() {
        return smsaVerifiedBy;
    }

    public void setSmsaVerifiedBy(String smsaVerifiedBy) {
        this.smsaVerifiedBy = smsaVerifiedBy;
    }

    public LocalDateTime getSmsaVerifiedDate() {
        return smsaVerifiedDate;
    }

    public void setSmsaVerifiedDate(LocalDateTime smsaVerifiedDate) {
        this.smsaVerifiedDate = smsaVerifiedDate;
    }

    public String getSmsaAction() {
        return smsaAction;
    }

    public void setSmsaAction(String smsaAction) {
        this.smsaAction = smsaAction;
    }
}
