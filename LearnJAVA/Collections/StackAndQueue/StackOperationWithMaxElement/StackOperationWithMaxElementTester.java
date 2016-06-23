/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.StackAndQueue.StackOperationWithMaxElement;

/**
 * Created by Sachin on 6/7/2016.
 *
 * Problem Statement:
 * You have an empty sequence, and you will be given N queries. Each query is one of these three types:

 1 x  -Push the element x into the stack.
 2    -Delete the element present at the top of the stack.
 3    -Print the maximum element in the stack.

 Input Format
 The first line of input contains an integer, N. The next N lines each contain an above mentioned query. (It is guaranteed that each query is valid.)

 Constraints
 1<= N <= 10^5
 1<= x <= 10^9
 1<= type <= 3

 Output Format
 For each type 3 query, print the maximum element in the stack on a new line.

 Sample Input
 10
 1 97
 2
 1 20
 2
 1 26
 1 20
 2
 3
 1 91
 3

 Sample Output
 26
 91

 */

import java.util.*;

class StackOperationWithMaxElement
{

    private Deque<Integer> stack;
    private ArrayDeque<Integer> queue;

    {
        this.stack = new ArrayDeque<>();
        this.queue = new ArrayDeque<>();
    }
    public Queue<Integer> getQueue()
    {
        return queue;
    }
    public void push(int number)
    {
        stack.push(number);
    }
    public void pop()
    {
        if (stack.size()>0)
            stack.pop();
    }

    public void max()
    {
        Iterator<Integer> iterator = stack.iterator();

        if (stack.size() > 0)
        {
        int max = 0;
        if (iterator.hasNext())
        {
            max = iterator.next();
            while (iterator.hasNext())
            {
                int currentElement = iterator.next();
                if (max < currentElement)
                {
                    max = currentElement;
                }
            }
        }
            //System.out.println(stack.getFirst());
            queue.add(max);
        }
    }
}

public class StackOperationWithMaxElementTester
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        StackOperationWithMaxElement stackOpr = new StackOperationWithMaxElement();
        int numberofInputLines = scan.nextInt();
        scan.nextLine();
        for (int i=0; i< numberofInputLines; i++)
        {
            String input = scan.nextLine();
            String [] splittedInput = input.split(" ");
            switch (splittedInput[0])
            {
                case "1":
                    if (splittedInput.length>1)
                        stackOpr.push(Integer.parseInt( splittedInput[1]) );
                    break;
                case "2":
                    stackOpr.pop();
                    break;
                case "3":
                    stackOpr.max();
                    break;
                default:
                    break;
            }
        }
        System.out.println(stackOpr.getQueue().toString());
    }
}