/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.MAPs.PhoneBook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sachin on 20-06-2016.
 */
public class PhoneBook
{
    Map<String,Integer> phoneBook;

    {
        this.phoneBook = new HashMap<>();
    }

    public void addEntry (String name, Integer phoneNumber)
    {
        phoneBook.put(name,phoneNumber);
        //System.out.println("Added entry with " + name + " value = " + phoneNumber);
    }
    public boolean isNamePresentInPhoneBook (String name)
    {
        if (phoneBook.containsKey(name) )
            return true;
        else
            return false;
    }
    public Integer getValue (String name)
    {
        return phoneBook.get(name);
    }
    public void printPhoneBook ()
    {
        System.out.println(phoneBook);
    }
}
