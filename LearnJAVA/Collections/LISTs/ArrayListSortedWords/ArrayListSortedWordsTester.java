/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Collections.LISTs.ArrayListSortedWords;

import java.util.Scanner;

/**
 * Created by sachin on 15-06-2016.
 */
public class ArrayListSortedWordsTester
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayListSortedWords listOfWords = new ArrayListSortedWords();
        String[] wordArray ;
        String origStr;
        origStr  = scan.nextLine();
        wordArray = origStr.split(" ");
        do
        {
            System.out.println("Sentence: " + origStr);
            for (int howManyWordsPerLineCnt = wordArray.length-1; howManyWordsPerLineCnt>-1; howManyWordsPerLineCnt--)
            {
                listOfWords.addWord(wordArray[howManyWordsPerLineCnt].toLowerCase());
            }
            System.out.println("Sorted: "+listOfWords.sortedWordList());
            listOfWords.clearList();
            origStr  = scan.nextLine();
            wordArray = origStr.split(" ");
        } while (!(wordArray[0].equalsIgnoreCase("exit")) || wordArray==null);

    }
}
