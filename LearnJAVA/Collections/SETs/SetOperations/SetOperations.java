/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.SETs.SetOperations;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by sachin on 10-06-2016.
 * Problem Statement:
 * Assume you have declared three sets a, b, and c and that sets a and b store Integers. Write statements that use methods from the Set interface
 to perform the following operations:
 a. c = (a ∪ b)
 b. c = (a ∩ b)
 c. c = (a – b)
 d. if (a ⊂ b)
 c = a;
 else
 c = b;

 */
public class SetOperations
{
    public HashSet<Integer> getValuesForSet(HashSet<Integer> auxSet)
    {
        System.out.println("Enter integers values to store in set: ");
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            try
            {
                // Accept the number from user using console
                auxSet.add(scan.nextInt() );
                scan.nextLine();
            }catch (InputMismatchException IME)
            {
                scan.nextLine();
                System.out.println("Do you want finish adding the numbers (Y/N) => ");
                if (scan.nextLine().equalsIgnoreCase("y") )
                {
                    System.out.println("\nYour created Set as follows: ");
                    System.out.println(auxSet.toString() + "\n");
                    break;
                }
                else {
                   // scan.nextLine();
                    continue;
                }

            }
        }    // while loop ends here
        return auxSet;
    } // Method getValuesForSet ends here

    public HashSet<Integer> performUnionOfTwoIntegerSets(HashSet<Integer> setA, HashSet<Integer> setB)
    {
        HashSet<Integer> setC = new HashSet<>(setA);
        setC.addAll(setB);
        return setC;
    }

    public HashSet<Integer> performIntersectionOfTwoIntegerSets(HashSet<Integer> setA, HashSet<Integer> setB)
    {
        HashSet<Integer> setC = new HashSet<>(setA);
        setC.retainAll(setB);
        return setC;
    }

    public HashSet<Integer> performMinusOfTwoIntegerSets(HashSet<Integer> setA, HashSet<Integer> setB)
    {
        HashSet<Integer> setC = new HashSet<>(setA);
        setC.removeAll(setB);
        return setC;
    }
    public HashSet<Integer> performSubsetOfTwoIntegerSets(HashSet<Integer> setA, HashSet<Integer> setB)
    {
        if (setB.containsAll(setB) )
        {
            return setB;
        }
        else if (setB.containsAll(setA))
        {
            return setA;
        }
        else
        {
            return  setB;
        }
    }
    public static void main(String [] args)
    {
        SetOperations setHandler = new SetOperations();
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        // Get Values for two SETs
        setA = setHandler.getValuesForSet(setA);
        setB = setHandler.getValuesForSet(setB);

        // Perform different operations on two sets defined above
        try
        {
            // UNION of TWO SETS
            System.out.println("UNION Operation result: All elements in Both sets without duplication.\nSet A = " + setA.toString() + "\nSet B = " + setB.toString() +
                    "\n(SetA ∪ SetB) = \n" + setHandler.performUnionOfTwoIntegerSets(setA,setB) );

            // INTERSECTION of TWO SETS
            System.out.println("INTERSECTION Operation result: Only common elements from both sets.\nSet A = " + setA.toString() + "\nSet B = " + setB.toString() +
                    "\n(SetA ∩ SetB) = \n" + setHandler.performIntersectionOfTwoIntegerSets(setA,setB) );

            // MINUS of TWO SETS
            System.out.println("MINUS Operation result:All elements from first set which are not present in the second set\nSet A = " + setA.toString() + "\nSet B = " + setB.toString() +
                    "\n(SetA - SetB) = \n" + setHandler.performMinusOfTwoIntegerSets(setA,setB) );

            // SUBSET of TWO SETS
            System.out.println("SUBSET Operation result:\nSet A = " + setA.toString() + "\nSet B = " + setB.toString() +
                    "\n(SetA ⊂ SetB then SetA) OR (SetB ⊂ SetA then SetB) OR Default SetB = \n" + setHandler.performSubsetOfTwoIntegerSets(setA,setB) );
        }
        catch (UnsupportedOperationException UOE)
        {
            System.out.println("Operation is not supported by the Set \n" + UOE.getMessage());
        }
        catch (ClassCastException CCE)
        {
            System.out.println("Two collections have different element types \n" + CCE.getMessage());
        }
        catch (NullPointerException NPE)
        {
            System.out.println("Collections contains NULL value which is not allowed \n" + NPE.getMessage());
        }
        catch (IllegalArgumentException IAE)
        {
            System.out.println("Specified Collection's element property does not allow the operation \n" + IAE.getMessage());
        }
        catch (IllegalStateException ISE)
        {
            System.out.println("There is an insertion restriction on the given Collection \n" + ISE.getMessage());
        }
    }
}
