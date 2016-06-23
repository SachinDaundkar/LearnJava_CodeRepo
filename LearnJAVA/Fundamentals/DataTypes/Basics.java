/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Fundamentals.DataTypes;

import java.util.Scanner;

/**
 * Created by sachin on 15-06-2016.
 */
public class Basics
{
    public static void main (String [] args)
    {
           // Basics.knowYourVariables();
            Basics.calculateSalary();
    }

    private static void calculateSalary()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter employee and its basic salary");
        String empNo = scan.nextLine();
        String empName = scan.nextLine() ;
        double basic = scan.nextDouble();
        scan.nextLine();
        double DA = basic * 0.50;
        double HRA = basic * 0.25;
        double PF = basic * 0.10;
        double CCA = 240d;
        double PT = 100d;

        double netSalary = basic + DA + HRA - PF ;//- PT - CCA;
        double grossSalary = basic + DA + HRA;

        System.out.println(empName + " has employee number " + empNo);
        System.out.println("GrossSalary = " + grossSalary);
        System.out.println("Netsalary = " + netSalary);



    }

    private static void knowYourVariables()
    {
        // program expects making the variable final and assign them value once and then print it
        // I just tried getting them from user and printed
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter values for your variables: 2 int, char, float, double, 2long, boolean, string");
        int intVar1 = scan.nextInt();    scan.nextLine();
        int intVar2 = scan.nextInt();   scan.hasNextLine();
        char char1 = scan.next().charAt(0);
        float float1 = scan.nextFloat();  scan.nextLine();
        double double1 = scan.nextDouble(); scan.nextLine();
        long long1 = scan.nextLong(); scan.nextLine();
        long long2 = scan.nextLong(); scan.nextLine();
        boolean boolean1 = scan.nextBoolean(); scan.nextLine();
        String string1 = scan.nextLine();

        System.out.println("Variable values are: ");
        System.out.println("intVar1 = "+intVar1 );
        System.out.println("intVar2 = "+intVar2 );
        System.out.println("char1 = " + char1);
        System.out.println("float1 = " + float1);
        System.out.println("double1 = " + double1);
        System.out.println("Long1 = " + long1);
        System.out.println("Long2 = " +long2);
        System.out.println("Boolean = " + boolean1);
        System.out.println("String = " + string1);
    }
}
