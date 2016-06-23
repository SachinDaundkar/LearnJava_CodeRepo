package com.LearnJava_CodeRepo.LearnJAVA.Collections.StackAndQueue.ParenthesisNesting;

/**
 * Created by Sachin on 6/7/2016.
 *   Problem Statement:
 *   A string S consisting of N characters is called properly nested if:
 S is empty;
 S has the form "(U)" where U is a properly nested string;
 S has the form "VW" where V and W are properly nested strings.
 For example, string "(()(())())" is properly nested but string "())" isn't.

 Write a function:
 class Solution { public int solution(String S); }
 that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

 Assume that:
N is an integer within the range [0..1,000,000];
 string S consists only of the characters "(" and/or ")".

 */
import java.util.LinkedList;
import java.util.Scanner;

public class ParenthesisNesting
{
    public static void main(String[] args)
    {
        System.out.println("Please type 'exit' to terminate the program");
        Scanner scan = new Scanner(System.in);
        ParenthesisNesting pnObject = new ParenthesisNesting();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("exit"))

        {
            boolean result = pnObject.validateStringForParenthesisNesting(input);
            if (result)
            {
                System.out.println("Input String => " + input + " is VALID");
            }
            else
            {
                System.out.println("Input String => " + input + " is INVALID");
            }
            input = scan.nextLine();
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
