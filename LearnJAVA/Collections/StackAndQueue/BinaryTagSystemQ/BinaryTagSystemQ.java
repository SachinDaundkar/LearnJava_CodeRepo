/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.StackAndQueue.BinaryTagSystemQ;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sachin on 14-06-2016.
 * Problem Statement:
 * Write a program that reads in a binary string from the command line and applies the following (00, 1101) tag-system: if the first bit is 0, delete the first three bits and append 00; if the first bit is 1, delete the first three bits and append 1101. Repeat as long as the string has at least 3 bits. Try to determine whether the following inputs will halt or go into an infinite loop. Use a queue.

 Sample Input

 0101

 Sample Output

 Binary string after applying tag-system reduced to 3 digits

 Note: if it is not reduced to the 3 digits then give message "Binary string resulted into infinite loop"

 */
public class BinaryTagSystemQ
{
    private Queue<Integer> binary;
    {
        binary = new ArrayDeque<>();
    }

    public void removeDigits (int tag) throws InterruptedException
    {
        System.out.println("We got "+ tag + " to remove and after that Queue is  ");
            for(int i=0; i<3; i++)
            {
                if (!binary.isEmpty())this.binary.remove();
            }
        System.out.println(binary.toString());
        Thread.sleep(1000);
    }

    public void addDigits (int tag)   throws InterruptedException
    {
        System.out.println("We got "+ tag + " to add and after that Queue is  ");
        Integer intStr[] = {0,0};
        if (tag == 0)
        {   tag = 2; }
        else if (tag == 1)
        { tag = 4; intStr = new Integer[]{1,1,0,1}; }
        else tag = 0;

        for(int i=0; i<tag; i++)
        {
            this.binary.add(intStr[i]);
        }
        System.out.println(binary.toString());
        Thread.sleep(1000);
    }

    public void addOriginalInputString (StringBuilder origString)
    {
        for (int i=0; i <origString.length();i++)
        {
            this.binary.add(Integer.parseInt(""+origString.charAt(i)));
        }
        System.out.println("queue after adding entered string " + binary.toString());
        //Thread.sleep(2000);
    }
    public int getSize()
    {
        return binary.size();
    }

    public int getCurrentDigit()
    {
        if (!binary.isEmpty())
            return binary.remove();
        return 5;
    }

    public int knowNextDigit()
    {
        return binary.element();
    }


}


