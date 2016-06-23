/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.MAPs.MapOfCubeSquare;

import java.util.Scanner;

/**
 * Created by sachin on 14-06-2016.
 */
public class MapOfCubeSquareTester
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        MapOfCubeSquare mcs = new MapOfCubeSquare();
        System.out.println("Enter integers to calculate Square and Cube => \n");
        int num = scan.nextInt();
        scan.nextLine();
        while ( num > Integer.MIN_VALUE)
        {
            mcs.addIntegerToMap(num);
            System.out.println("Current entries in Map " + mcs.toString());
            num = scan.nextInt();
            scan.nextLine();
        }
    }
}
