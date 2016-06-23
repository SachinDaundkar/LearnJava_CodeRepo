/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.LISTs.DoublyLinkList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by sachin on 15-06-2016.
 * Problem Statement:
 * Implement a linked list that uses doubly linked nodes. Double linked nodes have references to the next node in the list and back to the previous node in the list.  In this assignment you will implement a list class using a doubly linked structure as the internal storage container.

 you must add  the following methods to your LinkedList class.  E is the data type variable. It will hold what the data type is for the elements (thus the E) of a particular LinkedList object.
 •void addFirst(E item) // add an item to the front of this LinkedList
 •void addLast(E item) // add an item to the end of this LinkedList
 •E removeFirst() // remove the first item in this LinkedList
 •E removeLast() // remove the first item in this LinkedList
 •override the toString method. The data in the list should be listed between square brackets with a comma between each item and a single space after each comma. e.g. [A, B, C]

 */
public class DoublyLinkList<E>
{
    private Node first;
    private Node last;
    private int size;

    {
        size =0;
    }

    /** Class to keep track of data nodes inside the link list         */
    private class Node
    {
        E data;
        Node prev;
        Node next;

        public Node(E data, Node next,Node prev)
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    /** add an item to the front of this LinkedList **/
    public void addFirst(E data)
    {
        Node newNode = new Node(data, first, null);
        if(first != null ) {first.prev = newNode;}
        first = newNode;
        if(last == null) { last = newNode;}
        size++;
        //System.out.println("adding: "+data);
    }
    public void addLast(E data)
    {
        Node newNode = new Node(data, null, last);
        if(last != null) {last.next = newNode;}
        last = newNode;
        if(first == null) { first = newNode;}
        size++;
        //System.out.println("adding: "+data);
    }

    public E removeFirst() // remove the first item in this LinkedList
    {
        if (size == 0) throw new NoSuchElementException();
        final E element = first.data;
        final Node nodeToRemove = first.next;
        first.data = null;
        first.next = null; // help GC
        first = nodeToRemove;
        if (nodeToRemove == null)
            last = null;
        else
            nodeToRemove.prev = null;
        size--;
        return element;

    }
    public E removeLast() // remove the last item in this LinkedList
    {
        if (size == 0) throw new NoSuchElementException();
        final E element = last.data;
        final Node nodeToRemove = last.prev;
        last.data = null;
        last.prev = null; // help GC
        last = nodeToRemove;
        if (nodeToRemove == null)
            first = null;
        else
            nodeToRemove.next = null;
        size--;
        return element;

    }

    @Override
    public String toString()
    {
        //The data in the list should be listed between square brackets with a comma between each item
        // and a single space after each comma. e.g. [A, B, C]
        String result="[";

        Node currentNode = first;
        if (currentNode == null)
            return "[]";
        while(currentNode != null)
        {
            result = result + currentNode.data + ",";
            currentNode = currentNode.next;
        }
        return result.substring(0,result.length()-1) + "]";
    }

}

class Node
{
    private String data;
    private Node previous;
    private Node next;

    public Node()
    {
        data = null;
        previous = null;
        next=null;
    }
    public Node(String data, Node previous, Node next)
    {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public String getData()
    {
        return data;
    }
    public Node getPrevious()
    {
        return previous;
    }

    public Node getNext()
    {
        return next;
    }

    public void setPrevious(Node previous)
    {
        this.previous = previous;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}
