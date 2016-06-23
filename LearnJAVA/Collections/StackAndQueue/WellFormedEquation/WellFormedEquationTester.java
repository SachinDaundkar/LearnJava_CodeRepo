/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.StackAndQueue.WellFormedEquation;

/**
 * Created by Sachin on 6/7/2016.
 * Problem Statement:
 * Write a program that takes from standard input an expression without left parentheses and prints the equivalent infix expression with the parentheses inserted. For example, given the input

 Sample Input

 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )

 Sample Output

 ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )

 */

import java.util.*;

class WellFormedEquation
{

    private Deque<Character> wellFormedEquation;
    private Map<Character, String> auxiliaryEquationData;
    {
        this.wellFormedEquation = new ArrayDeque<>();
        this.auxiliaryEquationData = new HashMap<>();
    }

    public Deque<Character> getWellFormedEquation()
    {
        return wellFormedEquation;
    }

    public void setWellFormedEquation(Deque<Character> wellFormedEquation)
    {
        this.wellFormedEquation = wellFormedEquation;
    }

    public Map<Character, String> getAuxiliaryEquationData()
    {
        return auxiliaryEquationData;
    }

    public void setAuxiliaryEquationData(Map<Character, String> auxiliaryEquationData)
    {
        this.auxiliaryEquationData = auxiliaryEquationData;
    }


    public boolean printWellFormedEquationForEquationMissingLeftParenthesis(StringBuilder originalIncompleteEquation)
    {
        wellFormedEquation.clear();
        final boolean VALID = true;
        final boolean INVALID = false;
        StringBuilder partEquation  ;
        char replacementChar = 'A';

        //LinkedList<Character> stack = new LinkedList<>();
        if (originalIncompleteEquation.length()<=0)
        {
            this.setWellFormedEquation(new ArrayDeque<>());
            return VALID;
        }
        for (int charIndex = 0; charIndex < originalIncompleteEquation.length(); charIndex++)
        {
            char currentChar = originalIncompleteEquation.charAt(charIndex);

            if ( currentChar != ')' )
            {
                wellFormedEquation.push(currentChar);
            }
            else
            {
                int howManyCharsToPop = 1;
                partEquation = new StringBuilder();
                partEquation.append(currentChar);
                if (wellFormedEquation.size()>=3)
                {
                       howManyCharsToPop = 3;
                }
                    for (int i=0; i<howManyCharsToPop; i++)
                    {
                        if (wellFormedEquation.isEmpty())
                        {
                            return INVALID;
                        }
                        else
                        {
                            partEquation.append(wellFormedEquation.pop());
                        }
                    }
                partEquation.append('(');
                partEquation = partEquation.reverse() ;
                auxiliaryEquationData.put(++replacementChar,partEquation.toString());
                wellFormedEquation.push(replacementChar);
                //System.out.println("PartEquation = " + partEquation + " , replacement character = " + replacementChar + " wellformed eqn = " + wellFormedEquation.toString());
            }
        }

        StringBuilder auxSB ;
        StringBuilder finalEquation = new StringBuilder();
        while(replacementChar != 'A')
        {
            char currentChar = wellFormedEquation.pop();
            if (replacementChar == currentChar)
            {
                auxSB = new StringBuilder();
                auxSB.append(auxiliaryEquationData.get(replacementChar) );
                  for (int j=0; j<auxSB.length(); j++)
                  {
                      wellFormedEquation.push(auxSB.charAt(j));
                  }
                replacementChar--;

            }
            else
            {
                finalEquation.append(currentChar);
            }
           // replacementChar--;
        }    // while ends here

        while(!wellFormedEquation.isEmpty())
        {
            finalEquation.append(wellFormedEquation.pop());
        }

        for (int i=0;i<finalEquation.length();i++)
        {
            wellFormedEquation.push(finalEquation.charAt(i));
        }
        System.out.println("Final equation = " + finalEquation.reverse());
        return VALID;
    }
}

public class WellFormedEquationTester
{
    public static void main(String[] args)
    {
        System.out.println("Please type 'exit' to terminate the program");
        Scanner scan = new Scanner(System.in);
        WellFormedEquation wfe = new WellFormedEquation();
        StringBuilder originalIncompleteEquation = new StringBuilder(scan.nextLine());
        while (!"exit".equalsIgnoreCase(originalIncompleteEquation.toString()))
        {
            boolean result = wfe.printWellFormedEquationForEquationMissingLeftParenthesis(originalIncompleteEquation);
            if (!result)
            {
                System.out.println("Input String => " + originalIncompleteEquation + " is INVALID");
            }
            originalIncompleteEquation = new StringBuilder(scan.nextLine());
        }
    }
}