/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Fundamentals.Constructors.AreaPerimeter;

/**
 * Created by sachin on 16-06-2016.
 */
public class AreaPerimeter
{
    // area of rectangle  l b   perimeter = 2l 2b
    // area of box = l w h      perimeter of box = 2l 2w
    public static void main (String[] args)
    {
        Rectangle r1 = new Rectangle(4,5);
        Box b1 = new Box(4,5,6);
        System.out.println("R1 = " + r1);
        System.out.println("B1 = " + b1);
    }
}



class Rectangle
{
    protected double length;
    protected double breadth;
    protected double area;
    protected double perimeter;


    public Rectangle(double length, double breadth)
    {
        this.length = length;
        this.breadth = breadth;
        area();
        perimeter();
    }

    private void perimeter()
    {
        perimeter = (2*length) + (2*breadth);
    }

    private void area()
    {
        area = length * breadth;
    }

    @Override
    public String toString()
    {
        return "{" +
               "length=" + length +
               ", breadth=" + breadth +
               ", area=" + area +
               ", perimeter=" + perimeter +
               '}';
    }
}
class Box extends Rectangle
{
    private double height;

    public Box(double length, double breadth, double height)
    {
        super(length, breadth);
        this.height = height;
        area();
        perimeter();
    }
    private void area()
    {
        super.area = super.length * super.breadth * height;
    }
    private void perimeter()
    {
        super.perimeter = super.perimeter + (2*height);
    }

    @Override
    public String toString()
    {
        return "{" +
               "height=" + height +
               '}' + super.toString();
    }
}