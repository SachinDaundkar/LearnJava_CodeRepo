/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.MAPs.MapOfStringInitials;

/**
 * Created by sachin on 14-06-2016.
 */
public class MapOfStringInitialsTester
{
    public String[] getInputStrings()
    {
        return inputStrings;
    }

    public void setInputStrings(String[] inputStrings)
    {
        this.inputStrings = inputStrings;
    }

    private String [] inputStrings = {"code", "bug","","bugbug", "sachin"};

    @Override
    public String toString()
    {
        String result = "";
        //return super.toString();
        for (String str: this.getInputStrings())
        {
            result = result + "\""+str + "\",";
        }
        return result.substring(0,result.length()-1);
    }

    public static void main (String [] args)
    {
        MapOfStringInitials mapOfStringInitials = new MapOfStringInitials();
        MapOfStringInitialsTester tester = new MapOfStringInitialsTester();

        mapOfStringInitials.processArrayOfString(tester.getInputStrings());
        System.out.println("pairs ("+ tester.toString() + ") → " + mapOfStringInitials.getStringInitials());

        tester.setInputStrings( new String[]{"Sachin ", "Daundkar "});
        mapOfStringInitials.processArrayOfString(tester.getInputStrings());
        System.out.println("pairs ("+ tester.toString() + ") → " + mapOfStringInitials.getStringInitials());

    }

}
