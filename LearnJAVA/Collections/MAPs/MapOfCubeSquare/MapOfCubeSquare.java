/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.MAPs.MapOfCubeSquare;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sachin on 14-06-2016.
 * Problem Statement:
 * Create Map object which has integer as a key and in value it has key's square and key's cube.
 Take input from user and calculate square and cube from that input and store it in map:
 input as a key and square and cube as a value.
 Implement methods
 //returns square
 public int getSquare(int key);
 //returns cube
 public int getCube(int key);

 */
public class MapOfCubeSquare
{
    private Map<Integer,intOprations> integerIntOprationsMap ;

    public MapOfCubeSquare()
    {
        this.integerIntOprationsMap = new HashMap<>();
    }

    @Override
    public String toString()
    {
        String result="\n";
        for (int i:integerIntOprationsMap.keySet())
        {
            result = result + "Key = " + i +", "+ integerIntOprationsMap.get(i).toString() + "\n" ;
        }
        return result;
    }

    public void addIntegerToMap (int num)
    {
        if (num>0)
        {
            this.integerIntOprationsMap.put(num,new intOprations(num))  ;
        }
    }
}

