package com.LearnJAVA;

/**
 * Created by sachin on 31-05-2016.
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Solution pnObject = new Solution();

        while (scan.hasNext())
        {
            String input=scan.next();

            boolean result = pnObject.validateStringForParenthesisNesting(input);
            if (result)
            {
                System.out.println("true");
            }
            else
            {
                System.out.println("false");
            }
            //input = scan.nextLine();
        }
    }

    public boolean validateStringForParenthesisNesting(String InputString)
    {
        final  boolean VALID =  true;
        final  boolean INVALID =  false;
        LinkedList<Character> stack = new LinkedList<>();
        if (InputString.isEmpty())
            return VALID;

        for(int charIndex=0;charIndex<InputString.length();charIndex++)
        {
            char currentChar = InputString.charAt(charIndex);
            if(currentChar == '{' || currentChar == '[' || currentChar == '(')
            {
                stack.push(currentChar);
            }
            else
            {
                if(stack.isEmpty())
                {
                    return INVALID;
                }
                char corresponding = stack.pop();
                if(currentChar == ')' && corresponding != '(')
                {
                    return INVALID;
                }
                if(currentChar == ']' && corresponding != '[')
                {
                    return INVALID;
                }
                if(currentChar == '}' && corresponding != '{')
                {
                    return INVALID;
                }
            }
        }
        return stack.isEmpty() ? VALID : INVALID;
    }
}
