package com.LearnJAVA.Strings.TagContentExtractor;

/**
 * Created by sachin on 31-05-2016.
 * Problem Statement:
 * In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag like <tag>contents</tag>. Note that the corresponding end tag starts with a /.

 Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting the following criterion:
 1.The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> is not valid, because the text starts with an h1 tag and ends with a non-matching h2 tag.
 2.Tags can be nested, but content between nested tags is considered not valid. For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.
 3.Tags can consist of any printable characters.

 Input Format
 The first line of input contains a single integer,  N (the number of lines).
 The  N subsequent lines each contain a line of text.

 Constraints
 •1<=N<=100
 •Each line contains a maximum of  10 ^ 4 printable characters.
 •The total number of characters in all test cases will not exceed 10^6.

 Output Format
 For each line, print the content enclosed within valid tags.
 If a line contains multiple instances of valid content, print out each instance of valid content on a new line; if no valid content is found, print None.

 Sample Input
 4
 <h1>Nayeem loves counseling</h1>
 <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
 <Amee>safat codes like a ninja</amee>
 <SA premium>Imtiaz has a secret crush</SA premium>

 Sample Output
 Nayeem loves counseling
 Sanjay has no watch
 So wait for a while
 None
 Imtiaz has a secret crush

 *
 * Steps
     1. Get the number of lines (integer) as input using command line
     2. Validate user has entered valid number and which is in the range 1 to 100.
     3. If input number is valid, accept the string of data
     4. Process the line of data and store the result
     5. When all the lines are done print out the results.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagLangValidation
{
    private static final short MAX_NUMBER_OF_LINES_LIMIT = 100;
    private static final short PER_LINE_MAX_CHAR_LIMIT = 10000;
    private static final short MIN_NUMBER_OF_LINES_LIMIT = 1;
    private static final short DEFAULT_NUMBER_OF_LINES = 4;
    private static final int MAX_TOTAL_CHAR_LIMIT = 1000000;

    private StringBuilder inputString ;
    private ArrayList<String> result = new ArrayList<>();
    private short lineTrackerCnt;

    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in); // use the Scanner class to read from stdin
        TagLangValidation tlv = new TagLangValidation();


        short numOfLines;

        numOfLines = tlv.getTheValidNumberOfLines(scan);
        tlv.setLineTrackerCnt((short) 0);


        int totalCharTrackerCnt=0;
        while (tlv.getLineTrackerCnt() < numOfLines )
        {
            /*StringBuilder inputString = new StringBuilder();
            inputString.insert(0,scan.nextLine() ); */
            tlv.setInputString(new StringBuilder(scan.nextLine()));
            if (tlv.getInputString().length() <= PER_LINE_MAX_CHAR_LIMIT)
            {
                if (totalCharTrackerCnt + tlv.getInputString().length() <= MAX_TOTAL_CHAR_LIMIT)
                {
                    totalCharTrackerCnt += tlv.getInputString().length();

                    //tlv.setResult( tlv.validateInputString(tlv.getInputString()) );
                    tlv.validateInputString(tlv.getInputString(),false);
                    //System.out.println(tlv.getInputString());

                }
                else
                {
                    System.out.println("ERROR: The total number of characters in your Text exceeded max limit " + MAX_TOTAL_CHAR_LIMIT);
                }
            }
            else
            {
                System.out.println("ERROR: More than " + PER_LINE_MAX_CHAR_LIMIT +" characters in your input line ");
            }
            tlv.setLineTrackerCnt((short) (tlv.getLineTrackerCnt() + 1));

        }

        tlv.printResult();
        scan.close(); // close the scanner
    }

    public void printResult()
    {
        for (String str:this.result)
        {
            System.out.println(str);
        }
    }

    public void validateInputString(StringBuilder inputString, boolean isRecursiveCall)
    {
        short flag = 0;
        //Pattern r = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
        Pattern regEx = Pattern.compile("<(.+?)>([^<]+)</\\1>");
        Matcher matches = regEx.matcher(inputString.toString());
        if(matches.find())
        {
            //System.out.println ("g count " + matches.groupCount ());
            //System.out.println ("Found " + matches.group ());
            //System.out.println ("  starting at index " + matches.start () + " and ending at index " + matches.end ());
            //System.out.println ();
            if (matches.group(2).length() !=0)
            {
                // System.out.println(m.group(2).length());
                this.setResult( matches.group(2) );
                flag = (short)1;
                //return  matches.group(2) ;

            }
            //System.out.println("matches.find() = " + matches.find());
            if (matches.end() < inputString.toString().length())
            {
                /*System.out.println("Inside recursive call");
                System.out.println("matches.end() = " + matches.end() );
                System.out.println("inputString.toString().length() = "+inputString.toString().length());*/
                this.validateInputString(new StringBuilder(inputString.substring(matches.end(),inputString.toString().length())),true );
                //this.setInputString(new StringBuilder( inputString.substring(matches.end(),inputString.toString().length()) ) );
                //this.setLineTrackerCnt((short) (this.getLineTrackerCnt() - 1));

            }
        }

        if (flag == 0 && isRecursiveCall == false)
        {
            this.setResult( "None" );
        }

     //return "None";
    }

    public short getTheValidNumberOfLines(final Scanner scan)
    {
        short numOfLines = 0;
        // take the count of number of lines from user
        try {
            numOfLines = scan.nextShort();
            while (numOfLines > MAX_NUMBER_OF_LINES_LIMIT || numOfLines < MIN_NUMBER_OF_LINES_LIMIT)
            {
                System.out.println("Valid number of lines are (1 to 100)... Please enter integer in this range : ");
                numOfLines = scan.nextShort();
            }
            scan.nextLine();
        } catch (InputMismatchException ime) {
            System.out.println("You entered invalid number of lines expected is an integer value");
            System.out.println("Number of lines are set to default value of 4");
            scan.nextLine();
            return DEFAULT_NUMBER_OF_LINES;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numOfLines;
    }


    public StringBuilder getInputString() {
        return inputString;
    }

    public void setInputString(StringBuilder inputString) {
        this.inputString = inputString;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(String lineResult)
    {
        this.result.add(lineResult);
    }
    public short getLineTrackerCnt() {
        return lineTrackerCnt;
    }

    public void setLineTrackerCnt(short lineTrackerCnt) {
        this.lineTrackerCnt = lineTrackerCnt;
    }
}

