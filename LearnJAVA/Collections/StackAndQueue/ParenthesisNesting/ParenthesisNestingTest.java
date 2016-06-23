package com.LearnJAVA.Collections.StackAndQueue.ParenthesisNesting;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Sachin on 6/7/2016.
 */
public class ParenthesisNestingTest
{
    @Test
    public void checkValidStringReturnsCorrectResult() throws Exception
    {
        ParenthesisNesting pnObject = new ParenthesisNesting();
        String input = "(()(())())";
        assertEquals("Input String => " + input + " is VALID",true,pnObject.validateStringForParenthesisNesting(input));
    }

    @Test
    public void checkInValidStringReturnsCorrectResult() throws Exception
    {
        ParenthesisNesting pnObject = new ParenthesisNesting();
        String input = "(()(())()";
        assertEquals("Input String => " + input + " is INVALID",false,pnObject.validateStringForParenthesisNesting(input));
    }
}