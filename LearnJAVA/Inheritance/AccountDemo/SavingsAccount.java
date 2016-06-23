/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Inheritance.AccountDemo;

/**
 * Created by sachin on 15-06-2016.
 */
public class SavingsAccount extends Account
{
    public double getInterest()
    {
        return interest;
    }

    public void setInterest(double interest)
    {
        this.interest = interest;
    }

    private double interest;

    public SavingsAccount()
    {
        this.interest = 4;
    }

    public void addInterest ()
    {
        System.out.println("Current Account Balance = " + this.getBalance());
        this.setBalance(this.getBalance() + ((interest * this.getBalance()) / 100) );
        System.out.println("Balance after adding the interest = " + this.getBalance() );
    }


}
