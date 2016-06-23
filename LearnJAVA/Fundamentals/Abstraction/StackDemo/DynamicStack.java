/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Fundamentals.Abstraction.StackDemo;

import java.util.Arrays;

/**
 * Created by sachin on 16-06-2016.
 */
public class DynamicStack<E> implements Stack<E>
{
    int size = 0;
    protected Object[] elementData ;
    protected int elementCount;

    public DynamicStack()
    {
        elementData = new Object[]{};
    }
    public int getSize()
    {
        return size;
    }

    @Override
    public synchronized E push(E item)
    {
        size++;
        elementData = Arrays.copyOf(elementData, size);
        elementData[elementCount++] = item;
        //System.out.println(Arrays.toString(elementData));
        return item;
    }

    public synchronized E pop()
    {
        E obj;
        obj = peek();
        if (getSize() < 1)
            return (E) "Stack empty: nothing to pop" ;
        else
        {
            System.arraycopy(elementData, 0, elementData, 0, size-1);
            //Arrays.copyOf(elementData,size-1);
        }
        elementCount--;
        size--;
        elementData[elementCount] = null;
        return obj;
    }

    public boolean empty()
    {
        return getSize() == 0;
    }

    public synchronized E peek()
    {
        if (getSize() == 0)
        {
            return (E) "Empty Stack: No Peek";
        }
        return (E) elementData[getSize()-1];
    }
} // Class Ends here