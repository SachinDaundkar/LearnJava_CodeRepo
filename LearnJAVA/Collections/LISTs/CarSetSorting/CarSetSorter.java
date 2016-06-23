/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.LISTs.CarSetSorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sachin on 15-06-2016.
 * Problem Statement:
 * Make a record to store information about a car. It should contain fields for: •the make (String)
 •the model (String)
 •the year (int)
 •the license-plate number (String)

 Create an ArrayList of Car objects.

 Ask the user for the name of a file, and then open that file and read all that data from that file into the ArrayList.

 Finally, sort the ArrayList of cars by year and print them out.

 Sample Output
 From which file do you want to load this information? cars.txt
 Data loaded.
 Data sorted.

 ArrayList: [1966 Ford Mustang (AZUCAR), 1980 Chevrolet Chevette (J43-SMB), 1985 Toyota Camry (622-VRX)]

 */
public class CarSetSorter
{
    ArrayList<Car> carList;
    {
        carList = new ArrayList<>();
    }
    public void addCarDetails (String make, String model, int year, String licenceNum)
    {
        carList.add(new Car(make,model,year,licenceNum) );
    }
    public void sortedCarDetails()
    {
        carList.sort((o1, o2) -> (o1.getYear()>o2.getYear())?1:-1);
        //Collections.sort(carList,(o1, o2) -> (o1.getYear()>o2.getYear())?1:-1);

    }
    public String  printCarDetails()
    {
        return carList.toString();
    }
}

class Car
{
    private String make;
    private String model;
    private int year;
    private String licenceNum;


    public Car(String make, String model, int year, String licenceNum)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licenceNum = licenceNum;
    }
    public int getYear()
    {
        return year;
    }

    @Override
    public String toString()
    {
        return String.format("\nMake=%10s,Model=%10s,Year=%4s,LicenceNumber=%10s",make,model,year,licenceNum);
    }
}
