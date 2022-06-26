package com.example.demo.Model;

import com.example.demo.Model.Enums.Currency;
import com.example.demo.Model.Enums.FirmType;
import com.example.demo.Model.Enums.PaymentStatus;

public class Expense
{
    private int id;
    private FirmType firmType;
    private String billNumber;
    private String customerName; //tedarikçi
    private Currency currency;
    private PaymentStatus paymentStatus;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FirmType getFirmType() {
        return firmType;
    }

    public void setFirmType(FirmType firmType) {
        this.firmType = firmType;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
