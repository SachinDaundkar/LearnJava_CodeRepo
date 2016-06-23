/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.StackAndQueue.BinaryTagSystemQ;

import java.util.Scanner;

/**
 * Created by sachin on 15-06-2016.
 * Problem Statment
 * Write a program that reads in a binary string from the command line and applies the following (00, 1101) tag-system: if the first bit is 0, delete the first three bits and append 00; if the first bit is 1, delete the first three bits and append 1101. Repeat as long as the string has at least 3 bits. Try to determine whether the following inputs will halt or go into an infinite loop. Use a queue.

 Sample Input

 0101

 Sample Output

 Binary string after applying tag-system reduced to 3 digits

 Note: if it is not reduced to the 3 digits then give message "Binary string resulted into infinite loop"

 */
public class BinaryTagSystemQTester
{
    public static void main (String [] args) throws InterruptedException
    {
        BinaryTagSystemQ binaryTagSystemQHandler = new BinaryTagSystemQ();
        Scanner scan = new Scanner(System.in);
        int flag = 0;

        StringBuilder binaryInputStr = new StringBuilder(scan.nextLine());
        binaryTagSystemQHandler.addOriginalInputString(binaryInputStr);

        while (binaryTagSystemQHandler.getSize()>3 && flag==0)
        {
            if (binaryTagSystemQHandler.getSize()<1000)
             {
                 //System.out.println(binaryTagSystemQHandler.getSize());
                 int currDigit = binaryTagSystemQHandler.getCurrentDigit();

                 if (currDigit ==5)
                    flag = 5;
                 if (binaryTagSystemQHandler.getSize()>3)
                 {
                     binaryTagSystemQHandler.removeDigits(currDigit);
                 }    else { flag=5; }
                 if (binaryTagSystemQHandler.getSize()>0)
                 {
                     if (binaryTagSystemQHandler.getSize() ==1 && binaryTagSystemQHandler.knowNextDigit()==1)
                     { flag =1; }
                     binaryTagSystemQHandler.addDigits(currDigit);
                 } else { flag = 5;}

                 System.out.println("current digit " + currDigit);
             }
             else
             {
                 flag = 1;
             }
        }
        if (flag == 5)
        {
            System.out.println("Binary string after applying tag-system reduced to 3 digits");
        }
        else
            System.out.println("Binary string resulted into infinite loop");
    }
}
