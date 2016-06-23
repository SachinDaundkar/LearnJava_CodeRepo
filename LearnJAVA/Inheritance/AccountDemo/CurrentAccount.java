/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Inheritance.AccountDemo;

/**
 * Created by sachin on 15-06-2016.
 */
public class CurrentAccount extends Account
{
    private double overdraftLimit;

    public CurrentAccount()
    {
        this.overdraftLimit = 10;
    }

    public double getOverdraftLimitAmount()
    {
        return (this.getBalance() * overdraftLimit) / 100;
    }

    public void setOverdraftLimit(double overdraftLimit)
    {
        this.overdraftLimit = overdraftLimit;
    }

}
