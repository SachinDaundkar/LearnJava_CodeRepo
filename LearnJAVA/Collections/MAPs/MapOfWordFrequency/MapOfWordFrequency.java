/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Collections.MAPs.MapOfWordFrequency;

import java.util.HashMap;


/**
 * Created by sachin on 14-06-2016.
 * Problem Statement:
 * Write statements to create a Map object that will store each word occurring in a text file along with the number of times the word occurs.
 */
public class MapOfWordFrequency
{
    private HashMap<String, Integer> wordFreqMap;
    {
        this.wordFreqMap = new HashMap<>();
    }

    public void addWordToMap (String word)
    {
        if (this.wordFreqMap.get(word)==null)
        {
            this.wordFreqMap.put(word,1);
        }
        else
        {
            this.wordFreqMap.put(word,wordFreqMap.get(word)+1);
        }
        /*try
        {
            this.wordFreqMap.forcePut(word,wordFreqMap.get(word)+1);
        }
        catch (NullPointerException NPE)
        {
            this.wordFreqMap.put(word,1);
        }*/

    }

    @Override
    public String toString()
    {
        //String result = "";
        System.out.printf("%-12s%-12s\n","Key","Value");
        for (String keyStr :wordFreqMap.keySet())
        {
            System.out.printf("%-12s%s\n", keyStr,wordFreqMap.get(keyStr));
        }
        return "";
    }
}
