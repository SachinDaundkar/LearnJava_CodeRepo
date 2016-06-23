/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.MAPs.MapOfCubeSquare;

/**
 * Created by sachin on 14-06-2016.
 */
public class intOprations
{
    private  long Square;
    private long Cube;

    public intOprations(int num)
    {
        this.Square = this.getSquare(num);
        this.Cube = this.getCube(num);
    }
    //returns square
    public int getSquare(int key)
    {
        return Math.multiplyExact(key,key);
    }
    //returns cube
    public int getCube(int key)
    {
        return Math.multiplyExact(key,Math.multiplyExact(key,key));
    }

    @Override
    public String toString()
    {
        return "Square = " + Square + " Cube = " + Cube;
    }
}
