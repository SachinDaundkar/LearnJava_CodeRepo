/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Collections.LISTs.ArrayListSortedWords;

import java.util.ArrayList;

/**
 * Created by sachin on 15-06-2016.
 * Problem Statement:
 * Write a program that creates an ArrayList of Strings. Let the user type in a sentence; break up the sentence into an array of Strings and then put those Strings into an ArrayList. Also, force all the Strings to lowercase.
 Then, using the String ArrayList sorting function you already wrote, put the words in alphabetical order and print them out again.

 Sample Output
 Sentence: How I want a drink alcoholic of course after the heavy lectures involving Quantum Mechanics
 Sorted: [a, after, alcoholic, course, drink, heavy, how, i, involving, lectures, mechanics, of, quantum, the, want]

 */
public class ArrayListSortedWords
{
    private ArrayList<String> wordList;
    {
        this.wordList = new ArrayList<>();
    }

    public void addWord(String word)
    {
        this.wordList.add(word);
    }

    public String sortedWordList()
    {
        this.wordList.sort(String::compareToIgnoreCase);
        return wordList.toString();
    }
    public void clearList()
    {
        wordList.clear();
    }

}
