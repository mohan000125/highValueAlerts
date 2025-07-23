package com.smsa.highValueAlerts.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RECEPIENT_TEMP")
public class RecepientTemp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "threshold_seq_gen")
    @SequenceGenerator(name = "threshold_seq_gen", sequenceName = "SMSA_RAM_SEQ", allocationSize = 1)
    @Column(name = "SMSA_RAM_ID", nullable = false)
    private Long smsaRamId;

    @Column(name = "SMSA_EMP_ID", length = 10)
    private String smsaEmpId;

    @Column(name = "SMSA_GEO_NAME", length = 20)
    private String smsaGeoName;

    @Column(name = "SMSA_SENDER_BIC", length = 20)
    private String smsaSenderBic;

    @Column(name = "SMSA_MSG_TYPE")
    private Integer smsaMsgType;

    @Column(name = "SMSA_EMP_NAME", length = 150)
    private String smsaEmpName;

    @Column(name = "SMSA_GRADE", length = 10)
    private String smsaGrade;

    @Column(name = "SMSA_CREATED_BY", length = 10)
    private String smsaCreatedBy;

    @Column(name = "SMSA_MODIFIED_BY", length = 10)
    private String smsaModifiedBy;

    @Column(name = "SMSA_MODIFIED_DATE")
    private LocalDateTime smsaModifiedDate;

    @Column(name = "SMSA_VERIFIED_BY", length = 10)
    private String smsaVerifiedBy;

    @Column(name = "SMSA_VERIFIED_DATE")
    private LocalDateTime smsaVerifiedDate;

    @Column(name = "SMSA_ACTION", length = 10)
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

    public Integer getSmsaMsgType() {
        return smsaMsgType;
    }

    public void setSmsaMsgType(Integer smsaMsgType) {
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