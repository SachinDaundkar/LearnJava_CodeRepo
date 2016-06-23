/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Fundamentals.Abstraction.ThreadDemo;

/**
 * Created by sachin on 16-06-2016.
 */
public class ThreadDemo
{
    public static void main (String [] args)
    {
        Thread firstThread = new Thread(new FirstThread());
        Thread secondThread = new Thread(new SecondThread());
        firstThread.start();
        secondThread.start();
    }
}
class FirstThread implements Runnable
{

    @Override
    public void run()
    {
        int i = 1;
        while (i<11)
        {
            System.out.println("Message from First Thread : " + i++);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}
class SecondThread implements Runnable
{

    @Override
    public void run()
    {
        int i = 11;
        while (i<21)
        {
            System.out.println("Message from Second Thread : " + i++);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
