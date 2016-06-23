package com.LearnJAVA.Strings.TagContentExtractor;

import com.LearnJAVA.Strings.TagContentExtractor.TagLangValidation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sachin on 6/7/2016.
 */
public class TagLangValidationTest
{
    private TagLangValidation tlv;
    @Before
    public void setUp() throws Exception
    {
        tlv = new TagLangValidation();
    }

    @org.junit.After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void checkSingleLineWithValidTags() throws Exception
    {
        String inputLine = "<h1>Nayeem loves counseling</h1>";
        tlv.setInputString(new StringBuilder(inputLine));
        tlv.validateInputString(new StringBuilder(inputLine),false);
        for (String str:tlv.getResult())
        {
            assertEquals("Entered String => " + inputLine,"Nayeem loves counseling",str);
        }

    }
    @Test
    public void checkMultipleLinesWithDifferentTags() throws Exception
    {
        ArrayList<String> inputStrings = new ArrayList<>();
        inputStrings.add("<h1>Nayeem loves counseling</h1>");
        inputStrings.add("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>");
        inputStrings.add("<Amee>safat codes like a ninja</amee>");
        inputStrings.add("<SA premium>Imtiaz has a secret crush</SA premium>");

        for (String inputLine:inputStrings )
        {
            tlv.setInputString(new StringBuilder(inputLine));
            tlv.validateInputString(new StringBuilder(inputLine),false);
        }
        assertEquals("Count of Result",5,tlv.getResult().size());
        for (int i=0; i<tlv.getResult().size();i++)
        {
            switch (i)
            {
                case 0:
                    assertEquals("Verifying First Line of Input","Nayeem loves counseling",tlv.getResult().get(i));
                    break;
                case 1:
                    assertEquals("Verifying Second Line of Input","Sanjay has no watch",tlv.getResult().get(i));
                    i++;
                    assertEquals("Verifying Second Line of Input","So  wait for a while",tlv.getResult().get(i));
                    break;
                case 3:
                    assertEquals("Verifying Third Line of Input","None",tlv.getResult().get(i));
                    break;
                case 4:
                    assertEquals("Verifying Third Line of Input","Imtiaz has a secret crush",tlv.getResult().get(i));
                    break;
                default:
                    System.out.println("Invalid index");
                    break;
            }

        }


    }
    /*@Test
    public void something()
    {
        Given:
    }*/

}