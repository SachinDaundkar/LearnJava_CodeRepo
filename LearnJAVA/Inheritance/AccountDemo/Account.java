/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Inheritance.AccountDemo;

/**
 * Created by sachin on 15-06-2016.
 * problem Statement
 * Create a Account class as follows –

 Current balance
 Account number
 Method: Deposit
 Method: Withdraw

 Specification:

 Using the Account class as a base class, write two derived classes called SavingsAccount and CurrentAccount. A SavingsAccount object, in addition to the attributes of an Account object, should have an interest variable and a method which adds interest to the account. A CurrentAccount object, in addition to the attributes of an Account object, should have an overdraft limit variable. Ensure that you have overridden methods of the Account class as necessary in both derived classes.
 Now create a Bank class, an object of which contains an array of Account objects. Accounts in the array could be instances of the Account class, the SavingsAccount class, or the CurrentAccount class. Create some test accounts (some of each type).
 Write an update method in the bank class. It iterates through each account, updating it in the following ways: Savings accounts get interest added (via the method you already wrote); CurrentAccounts get a letter sent if they are in overdraft.
 The Bank class requires methods for opening and closing accounts, and for paying a dividend into each account.
 */
public class Account
{
    private int accountNumber;
    private double balance;
    private static final double MIN_ACC_BALANCE = 1000d;
    private static int accNumCnt = 1;

    {
        accountNumber = accNumCnt++ ;
        balance = 1000d;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void deposit(double amount)
    {
        System.out.println("Balance before deposit = " + this.balance);
        this.balance +=amount;
        System.out.println("Balance after deposit = " + this.balance);


    }
    public double withdraw (double amount)
    {
        if (this.getBalance() - amount > MIN_ACC_BALANCE )
            return this.balance -=amount;
        else
        {
            System.out.println("Withdrawal is not allowed ... Account balance can't be below minimum balance of " + MIN_ACC_BALANCE);
            return this.balance;
        }
    }

}
