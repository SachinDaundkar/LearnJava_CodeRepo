/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.LISTs.CarSetSorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by sachin on 15-06-2016.
 */
public class CarSetSorterTester
{
    public static void main (String[] args)
    {
        File file = new File("src\\com\\LearnJAVA\\Collections\\LISTs\\CarSetSorting\\CarDetails.txt");
        CarSetSorter carHandler = new CarSetSorter();
        //Year,Make,Model,LicenceNumber
        try
        {
            Scanner scan = new Scanner(file);
            int recordCnt =1;
            int year = 0,make = 0,model = 0,licNum=0;
            String[] carDetailLine;
            if (scan.hasNextLine())
            {
                carDetailLine = scan.nextLine().split(",");
                if (carDetailLine.length == 4)
                {
                    for (int i=0; i<carDetailLine.length;i++)
                    {
                        switch (carDetailLine[i].toLowerCase())
                        {
                            case "year":
                                year = i;
                                break;
                            case "make":
                                make=i;
                                break;
                            case "model":
                                model=i;
                                break;
                            case "licencenumber":
                                licNum=i;
                                break;
                            default:
                                throw new InputMismatchException("File header does not have correct column names and hence not processed => expected header is Year,Make,Model,LicenceNumber");
                        }
                    }
                }
                else
                {
                    throw new InputMismatchException("File contains invalid header line and hence not processed");
                }
            }

            while (scan.hasNextLine())
            {
                carDetailLine = scan.nextLine().split(",");
                if (carDetailLine.length==4)
                {
                    carHandler.addCarDetails(carDetailLine[make],carDetailLine[model],Integer.parseInt(carDetailLine[year]),carDetailLine[licNum]);
                }
                else
                {
                    System.out.println("File contains invalid Car record on line " +recordCnt);
                }
                recordCnt++;
            }
            System.out.println("Car details read as follows : " + carHandler.printCarDetails());
            carHandler.sortedCarDetails();
            System.out.println("Car details sorted over year" + carHandler.printCarDetails());
        }
        catch (FileNotFoundException e)
        {
            System.out.println(file.getAbsoluteFile());
            e.printStackTrace();
        }
        catch (InputMismatchException IME)
        {
            System.out.println("INSIDE IME: "+ IME.getMessage());
        }
    }
}
