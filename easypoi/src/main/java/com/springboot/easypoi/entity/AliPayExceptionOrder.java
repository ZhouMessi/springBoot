package com.springboot.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class AliPayExceptionOrder {

    @Excel(name = "账务流水号")
    private String financialSerialNum;

    @Excel(name = "业务流水号")
    private String businessSerialNum;

    @Excel(name = "商户订单号")
    private String merchantOrderNum;

    @Excel(name = "商品名称")
    private String productName;

    @Excel(name = "发生时间",importFormat = "yyyy-MM-dd HH:mm:ss",exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date occurrenceTime;

    @Excel(name = "对方账号")
    private String adverseAccount;

    @Excel(name = "收入金额（+元）")
    private Double income;

    @Excel(name = "支出金额（-元）")
    private Double amountPaid;

    @Excel(name = "账户余额（元）")
    private Double accountBalance;

    @Excel(name = "交易渠道")
    private String transaction;

    public String getFinancialSerialNum() {
        return financialSerialNum;
    }

    public void setFinancialSerialNum(String financialSerialNum) {
        this.financialSerialNum = financialSerialNum;
    }

    public String getBusinessSerialNum() {
        return businessSerialNum;
    }

    public void setBusinessSerialNum(String businessSerialNum) {
        this.businessSerialNum = businessSerialNum;
    }

    public String getMerchantOrderNum() {
        return merchantOrderNum;
    }

    public void setMerchantOrderNum(String merchantOrderNum) {
        this.merchantOrderNum = merchantOrderNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public String getAdverseAccount() {
        return adverseAccount;
    }

    public void setAdverseAccount(String adverseAccount) {
        this.adverseAccount = adverseAccount;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}