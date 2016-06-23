/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJava_CodeRepo.LearnJAVA.Fundamentals.Abstraction.StackDemo;

/**
 * Created by sachin on 16-06-2016.
 */
public class StackDemo
{
    public static void main(String [] args)
    {
/*        DynamicStack<Integer> DStack = new DynamicStack<>();
        System.out.println("Push =" + DStack.push(33));
        System.out.println("Peek =" + DStack.peek());
        System.out.println("Push =" + DStack.push(36));
        System.out.println("Empty = " + DStack.empty());
        System.out.println("Peek =" + DStack.peek());
        System.out.println("Pop = " + DStack.pop());
        System.out.println("Peek =" + DStack.peek());
        System.out.println("Pop = " + DStack.pop());
        System.out.println("Empty = " + DStack.empty());
        System.out.println("Pop = " + DStack.pop());*/

        FixedLenStack<String> FStack = new FixedLenStack<>();
        System.out.println("Push =" + FStack.push("sachin"));
        System.out.println("Peek =" + FStack.peek());
        System.out.println("Push =" + FStack.push("Daundkar"));
        System.out.println("Empty = " + FStack.empty());
        System.out.println("Peek =" + FStack.peek());
        System.out.println("Pop = " + FStack.pop());
        System.out.println("Peek =" + FStack.peek());
        System.out.println("Pop = " + FStack.pop());
        System.out.println("Empty = " + FStack.empty());
        System.out.println("Pop = " + FStack.pop());
        System.out.println("Push =" + FStack.push("sachin"));
        System.out.println("Push =" + FStack.push("sachin-1"));
        System.out.println("Push =" + FStack.push("sachin-2"));
        System.out.println("Push =" + FStack.push("sachin-3"));
        System.out.println("Push =" + FStack.push("sachin-4"));
        System.out.println("Push =" + FStack.push("string"));
    }
}

interface Stack<E>
{
    public E push(E item);
    public E pop();
    public boolean empty();
    public  E peek() ;
}

