/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Generics.LargestValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sachin on 16-06-2016.
 */
public class LargestValue
{
    public static void main (String[] args)
    {
        LargestValue lvHandler = new LargestValue();
        int[] intsArr =  {8,67,2,9};
        Integer[] integersArr = new Integer[] {};
        Double[] doublesArr = {34d,292d,67d};
        String[] strArr = {"Sachin","Daundkar","is","a","Spiderlogic", "employee","3289","!@#"};

         /*
         Error:(25, 39) java: method getLargestValue in class com.LearnJAVA.Generics.LargestValue.LargestValue cannot be applied to given types;
  required: java.lang.Comparable[]
  found: int[]
  reason: varargs mismatch; int[] cannot be converted to java.lang.Comparable
        System.out.println("integersArr = " + Arrays.toString(integersArr) + "\n Largest from array is "
                           + lvHandler.getLargestValue(intsArr) );*/

        System.out.println("integersArr = " + Arrays.toString(integersArr) + "\n Largest from array is "
                           + lvHandler.getLargestValue(integersArr) );
        System.out.println("doublesArr = " + Arrays.toString(doublesArr) + "\n Largest from array is "
                           + lvHandler.getLargestValue(doublesArr) );
        System.out.println("strArr = " + Arrays.toString(strArr) + "\n Largest from array is "
                           + lvHandler.getLargestValue(strArr) );

    }

    public  <T extends Comparable<T>> T getLargestValue(T... values)
    {
        if (values.length > 0)
        {
            T large = values[0];
            for (T value: values)
            {
                if (value.compareTo(large)>0 )
                    large = value;
            }
            return large;
        }

        return (T)"not valid as given array is Empty";
    }
}
