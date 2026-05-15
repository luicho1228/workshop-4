package com.plurasight;

import java.util.Date;

public class SalesContract extends Contract{

    private double saleTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinance;
    //private double monthlyPayment;

    public SalesContract(double saleTaxAmount, double recordingFee, double processingFee, boolean isFinance, Date date, String customerName, String customerEmail, boolean vehicleSold) {
        super(date,customerName,customerEmail,vehicleSold);
        this.saleTaxAmount = saleTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinance = isFinance;
    }

    public double getSaleTaxAmount() {
        return saleTaxAmount;
    }

    public void setSaleTaxAmount(double saleTaxAmount) {
        this.saleTaxAmount = saleTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return isFinance;
    }

    public void setFinance(boolean finance) {
        isFinance = finance;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
