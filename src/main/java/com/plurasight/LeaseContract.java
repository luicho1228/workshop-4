package com.plurasight;

import java.util.Date;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private int leaseFee;

    public LeaseContract(double expectedEndingValue, int leaseFee, Date date, String customerName, String customerEmail, boolean vehicleSold, double totalPrice) {
        super(date,customerName,customerEmail,vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public int getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(int leaseFee) {
        this.leaseFee = leaseFee;
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
