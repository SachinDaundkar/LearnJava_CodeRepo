/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Inheritance.AccountDemo;

/**
 * Created by sachin on 15-06-2016.
 * Problem Statement:
 * Create a Account class as follows –
 Current balance
 Account number
 Method: Deposit
 Method: Withdraw

 Specification:
 Using the Account class as a base class, write two derived classes called SavingsAccount and CurrentAccount. A SavingsAccount object, in addition to the attributes of an Account object, should have an interest variable and a method which adds interest to the account. A CurrentAccount object, in addition to the attributes of an Account object, should have an overdraft limit variable. Ensure that you have overridden methods of the Account class as necessary in both derived classes.
 Now create a Bank class, an object of which contains an array of Account objects. Accounts in the array could be instances of the Account class, the SavingsAccount class, or the CurrentAccount class. Create some test accounts (some of each type).
 Write an update method in the bank class. It iterates through each account, updating it in the following ways: Savings accounts get interest added (via the method you already wrote); CurrentAccounts get a letter sent if they are in overdraft.
 The Bank class requires methods for opening and closing accounts, and for paying a dividend into each account
 */
public class Bank
{
    private Account[] bankAccounts;
    private static int accountCounter = 0;

    public Bank(Account[] bankAccounts)
    {
        this.bankAccounts = bankAccounts;
    }

    public static void main (String [] args)
    {
        Bank sbiBank = new Bank(new Account[]{
                new Account(),new SavingsAccount(),new CurrentAccount()
        });

        sbiBank.openNewAccount("General");
        sbiBank.openNewAccount("saving");
        sbiBank.openNewAccount("current");

        for (int i=0; i<sbiBank.bankAccounts.length;i++)
        {
            sbiBank.update(sbiBank.bankAccounts[i]);
        }

    }
    public void openNewAccount(String type)
    {
        if (type.equalsIgnoreCase("Saving"))
        {
            bankAccounts[Bank.accountCounter++] = new SavingsAccount();
        }
        else if (type.equals("Current") )
        {
            bankAccounts[Bank.accountCounter++] = new CurrentAccount();
        } else  bankAccounts[Bank.accountCounter++] = new Account();
    }
    public void update(Account acc)
    {
        if (acc instanceof SavingsAccount)
        {
             ((SavingsAccount) acc).addInterest();
        }
        else if(acc instanceof CurrentAccount)
        {
            double overdraftlimit = ((CurrentAccount) acc).getOverdraftLimitAmount();
            acc.withdraw(acc.getBalance()+overdraftlimit);
        }
        else
        {
            System.out.println("Account is General Account, Acc No = "+ acc.getAccountNumber());
            System.out.println("Balance in the account is = " + acc.getBalance());
        }

    }
}
