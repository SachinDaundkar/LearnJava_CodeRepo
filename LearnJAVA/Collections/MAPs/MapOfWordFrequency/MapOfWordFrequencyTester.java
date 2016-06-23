/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Collections.MAPs.MapOfWordFrequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by sachin on 14-06-2016.
 */
public class MapOfWordFrequencyTester
{
    public static void main (String [] args)
    {
        MapOfWordFrequency mapOfWF = new MapOfWordFrequency();
        File file  = new File("src\\com\\LearnJAVA\\MAPs\\MapOfWordFrequency\\wordFreqInputFile.txt");
        try
        {
            //System.out.println(file.getAbsolutePath());
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine())
            {
                String[] line = scan.nextLine().split(" ");
                int wordNumberOnLine = line.length - 1;
                while (wordNumberOnLine > -1)
                {
                    mapOfWF.addWordToMap(line[wordNumberOnLine--]);
                }
            }
            System.out.println("Word Frequency details in given file is as follows => \n" );
            System.out.println( mapOfWF.toString());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File wordFreqInputFile.txt is not found");
            e.printStackTrace();
        }
    }
}
