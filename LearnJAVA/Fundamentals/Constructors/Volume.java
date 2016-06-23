/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Fundamentals.Constructors;

/**
 * Created by sachin on 16-06-2016.
 */
public class Volume
{
    public static void main (String[] args)
    {
        Box b1 =  new Box(4, 5, 6);
        Box b2 = new Box(10,20,15);
        Box b3 = new Box(3,6,9);

        System.out.println("Box1 => " + b1);
        System.out.println("Box2 => " + b2);
        System.out.println("Box3 => " + b3);
    }
}

class Box
{
    private double length;
    private double breadth;
    private  double height;
    private  double volume;

    public Box(double length, double breadth, double height)
    {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.volume = length * breadth * height;
    }

    @Override
    public String toString()
    {
        return "{ Length=" + length + ",Breadth="+breadth+",Height="+height+
               ",Volume=" + volume +
               '}';
    }
}
