package com.example.demo.Model;

import com.example.demo.Model.Enums.Currency;
import com.example.demo.Model.Enums.FirmType;
import com.example.demo.Model.Enums.PaymentStatus;

public class Expense
{
    private FirmType firmType;
    private String billNumber;
    private String customerName; //tedarikçi
    private Currency currency;
    private PaymentStatus paymentStatus;
}
