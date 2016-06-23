/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.MAPs.PhoneBook;

/**
 * Created by sachin on 20-06-2016.
 */
import java.util.*;

public class Solution
{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            in.nextLine();
            // Add phonebook entries
            phoneBook.addEntry(name,phone);
           // phoneBook.printPhoneBook();

        }
        while(in.hasNext()){
            String s = in.next();
            // Search phonebook for given entry
            Integer value = phoneBook.getValue(s);
            System.out.println( (value != null) ? s + "=" + value : "Not found" );
           /* if(Integer.signum(value) > 0)
            {
                System.out.println(s + "=" + phoneBook.getValue(s));
            }
            else
            {
                System.out.println("Not found");
            }*/
        }
        in.close();
    }
}
