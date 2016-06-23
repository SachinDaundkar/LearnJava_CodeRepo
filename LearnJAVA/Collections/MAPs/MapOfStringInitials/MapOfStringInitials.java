/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Collections.MAPs.MapOfStringInitials;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sachin on 14-06-2016.
 * Problem Statement:
 * Given an array of non-empty strings, return a Map<String, String> where for every different string in the array, there is a key of its first character with the value of its last character.
 pairs(["code", "bug"]) → {"b": "g", "c": "e"}

 */
public class MapOfStringInitials
{
    private Map<String,String> stringInitials;

    {
        this.stringInitials = new TreeMap<>();
    }

    public Map<String, String> getStringInitials()
    {
        return stringInitials;
    }

    public void processArrayOfString(String[] inputStrings)
    {
        this.stringInitials.clear();
        for (String str: inputStrings )
        {
            if (str.length()>0)
                stringInitials.put(""+str.charAt(0), ""+str.charAt(str.length()-1) )   ;
        }
    }
}
