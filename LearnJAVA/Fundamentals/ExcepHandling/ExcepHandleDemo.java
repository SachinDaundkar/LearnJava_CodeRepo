/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Fundamentals.ExcepHandling;

import java.util.InputMismatchException;

/**
 * Created by sachin on 16-06-2016.
 */
public class ExcepHandleDemo extends Exception
{
    public ExcepHandleDemo(String message, Throwable cause)
    {
        super(message, cause);
    }

    public static void main (String [] args)
    {
        Exception userDefinedException = new ExcepHandleDemo("This is Custom Exception created by Sachin"
                ,new Throwable("Cause is i / 0"));
        try
        {
            int i = 6;
            try
            {
                 i = 5 /0;
            }
            catch (ArithmeticException AE)
            {
                System.out.println("Inside AE exception: \n" + AE.getMessage());
                System.out.println("Let me create user defined exception => " + userDefinedException);
                System.out.println(userDefinedException.getCause());
            }
            System.out.println("i = " + i/0);
        }
        catch (InputMismatchException IME)
        {
            IME.printStackTrace();
        }
        catch (ArithmeticException AE)
        {
            System.out.println("I handled ArithmeticException outside hurray: \n" + AE.getMessage());
            System.out.println(AE.getCause());
            anotherDivisionTry();
        }
        finally
        {
            System.out.println("I am Finally block and I am always get executed");
            try
            {
                System.out.println("Trying Something inside the finally block");
            }
            catch (InputMismatchException IME)
            {
                System.out.println("This is inside the finally block where i caught the input mismatch exception");
                System.out.println(IME.getLocalizedMessage());
            }
        }
    }

    public static void anotherDivisionTry()
    {
        int i = 20 / 2 ;
        System.out.println("anotherDivisionTry() method does it for me after exception handling");
        throw new InputMismatchException("Sachin Manually fired this exception");
    }
}
