/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Inheritance.StudentDemo;

import java.util.Scanner;

/**
 * Created by sachin on 15-06-2016.
 * problem statment:
 * Use inheritance to display a student record
 Operations --

 The user enters a college student's identification number followed by the major and GPA.
 The application creates a college student object and displays the object to the screen.

 Specifications --

 First, create a class that defines a student. This class should contain at least two instance variables for identification number and GPA. It should also contain two constructors; a default one and one that accepts two values for the instance variables. In addition to set and get methods, the class should override the toString method from the Object class.
 Next, create a class that defines a college student. To do this, the class should inherit the above class. In addition to the inherited instance variables, this class should contain at least one more instance variable that defines the college student's major. This class should also contain a default constructor and one that accepts three values for the instance variables. The first statement in this constructor should call a constructor in the superclass. This class should also override the toString method.
 Code a driver class that carries out the operation of the project.
 */
public class StudentDemo
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
       do
       {
           System.out.println("Enter details for the College Student ");
           CollegeStudent cstud1 = new CollegeStudent();
           System.out.println("Enter Student ID ");
           cstud1.setIDNum(scan.nextInt());
           scan.nextLine();
           System.out.println("Enter GPA ");
           cstud1.setGPA( scan.nextLine().charAt(0));
           System.out.println("Enter Major ");
           cstud1.setMajor(scan.nextLine());
           System.out.println("Details you entered for the student is as follows " + cstud1.toString());
           System.out.println("do you want to continue? (Type n/N to exit");
       }while(!scan.nextLine().equalsIgnoreCase("n"));

    }
}
class Student
{
    private int IDNum;
    private char GPA;

    @Override
    public String toString()
    {
        return "Student{" +
               "IDNum=" + IDNum +
               ", GPA=" + GPA +
               '}';
    }

    public int getIDNum()
    {
        return IDNum;
    }

    public void setIDNum(int IDNum)
    {
        this.IDNum = IDNum;
    }

    public char getGPA()
    {
        return GPA;
    }

    public void setGPA(char GPA)
    {
        this.GPA = GPA;
    }

    public Student()
    {
    }

    public Student(int IDNum, char GPA)
    {
        this.IDNum = IDNum;
        this.GPA = GPA;
    }
}

class CollegeStudent extends Student
{
    private String major;
    public String getMajor()
    {
        return major;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }

    public CollegeStudent()
    {
    }
    public CollegeStudent(int IDNum, char GPA, String major)
    {
        super(IDNum, GPA);
        this.major = major;
    }

    @Override
    public String toString()
    {
        return "CollegeStudent{major='" + major + '\'' + super.toString()+ '}';
    }
}
