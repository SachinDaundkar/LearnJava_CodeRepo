/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Fundamentals.Abstraction.CircleSquare;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sachin on 16-06-2016.
 */
public class ShapeDemo
{
    public static void main(String [] args)
    {
        Circle C1 = new Circle(50);
        C1.draw();
        Rectangle Rect1 = new Rectangle(60,100);
        Rect1.draw();
    }
}

interface Shape
{
    public void draw();
}
class Circle extends JFrame implements Shape
{
    private int radius ;

    public Circle(int radius)
    {
        this.radius = radius;
    }

    @Override
    public void draw()
    {
        System.out.println("Lets Draw a circle");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void paint(Graphics g){
        g.drawOval(40, 40, 2*radius, 2*radius); //FOR CIRCLE
        //g.drawRect(200, 100, 100, 200); // FOR RECT
    }
}

class Rectangle extends JFrame implements Shape
{
    private int width;
    private int height;

    public Rectangle(int width,int height)
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw()
    {
        System.out.println("Lets Draw a Rectangle");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        g.drawRect(200, 100, width, height); // FOR RECT
    }
}
