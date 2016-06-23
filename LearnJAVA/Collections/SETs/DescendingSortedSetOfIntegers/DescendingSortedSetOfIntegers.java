/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.SETs.DescendingSortedSetOfIntegers;

import java.util.*;

/**
 * Created by sachin on 09-06-2016.
 * Problem Statement:
 * Create set of Integers. Accept integer inputs from user and add it to the set. Sort set in descending order and print it. Remove all integers <= 20 and again print it.

 */
public class DescendingSortedSetOfIntegers
{
    TreeSet<Integer> integerSet ;
    {
        this.integerSet = new TreeSet();
    }
    // Function to add number to the set
    public void addNumberToSet (int value)
    {
        this.integerSet.add(value);
    }

    // Function to print the set in descending order
    public void printSetInDescendingOrder()
    {
        try
        {
            System.out.println( this.integerSet.descendingSet() );
            this.integerSet.removeIf(integer -> integer<=20);
            System.out.println( this.integerSet.descendingSet() );
        }
        catch (NullPointerException NPE)
        {
            System.out.println("There is no element in the set you are trying to sort" + NPE.getMessage());
        }
        catch (UnsupportedOperationException UOE)
        {
            System.out.println("Removal of the element is not supported " + UOE.getMessage());
        }

    }

    public static void main(String [] args)
    {

        Scanner scan = new Scanner(System.in);
        DescendingSortedSetOfIntegers set_desc = new DescendingSortedSetOfIntegers();

        System.out.println("Enter Integer numbers  -> ");

        while (true)
        {
            try
            {
                // Accept the number from user using console
                set_desc.addNumberToSet(scan.nextInt());
                scan.nextLine();
            }catch (InputMismatchException IME)
            {
                System.out.println("You have entered incorrect value");
                scan.nextLine();
            }

            // Print the list in descending order
            System.out.println("Do you want to print the numbers in Desc Order (Y/N) => ");
            if (scan.nextLine().equalsIgnoreCase("y") )
            {
                set_desc.printSetInDescendingOrder();

            }
            // scan.nextLine();
        }    // while loop ends here
    } // main function ends here
} // Class ends here

