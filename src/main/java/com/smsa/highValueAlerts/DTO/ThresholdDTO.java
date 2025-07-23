package com.smsa.highValueAlerts.DTO;

import java.time.LocalDateTime;

public class ThresholdDTO {

    private Long thresholdId;
    private String msgCurrency;
    private String senderBic;
    private String msgType;
    private Long categoryAFromAmount;
    private Long categoryAToAmount;
    private Long categoryBFromAmount;
    private Long categoryBToAmount;
    private String createdBy;
    private LocalDateTime createdDate;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private String verifiedBy;
    private LocalDateTime verifiedDate;
    private String action;

    // Getters and Setters

    public Long getThresholdId() {
        return thresholdId;
    }

    public void setThresholdId(Long thresholdId) {
        this.thresholdId = thresholdId;
    }

    public String getMsgCurrency() {
        return msgCurrency;
    }

    public void setMsgCurrency(String msgCurrency) {
        this.msgCurrency = msgCurrency;
    }

    public String getSenderBic() {
        return senderBic;
    }

    public void setSenderBic(String senderBic) {
        this.senderBic = senderBic;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Long getCategoryAFromAmount() {
        return categoryAFromAmount;
    }

    public void setCategoryAFromAmount(Long categoryAFromAmount) {
        this.categoryAFromAmount = categoryAFromAmount;
    }

    public Long getCategoryAToAmount() {
        return categoryAToAmount;
    }

    public void setCategoryAToAmount(Long categoryAToAmount) {
        this.categoryAToAmount = categoryAToAmount;
    }

    public Long getCategoryBFromAmount() {
        return categoryBFromAmount;
    }

    public void setCategoryBFromAmount(Long categoryBFromAmount) {
        this.categoryBFromAmount = categoryBFromAmount;
    }

    public Long getCategoryBToAmount() {
        return categoryBToAmount;
    }

    public void setCategoryBToAmount(Long categoryBToAmount) {
        this.categoryBToAmount = categoryBToAmount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public LocalDateTime getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(LocalDateTime verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
