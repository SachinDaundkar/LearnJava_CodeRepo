/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Fundamentals.Constructors;

/**
 * Created by sachin on 16-06-2016.
 */
public class EmpConsDemo
{
    public static void main(String [] args)
    {
        Employee emp1 = new Employee(1,"Sachin");
        Employee emp2 = new Employee(2,"Sachin-2", 1000);
        Employee emp3 = new Employee(3,"Sachin-3", 2000,9890171096d,"sachin.daundkar@gmail.com",'A',true);
        System.out.println("emp1 => " + emp1);
        System.out.println("emp2 => " + emp2);
        System.out.println("emp3 => " + emp3);

    }
}

class Employee
{
    private int id ;
    private String name;
    private double salary;
    private double mobileNum;
    private String emailId;
    private char grade;
    private boolean isActive;

    public Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(int id, String name, double salary, double mobileNum, String emailId, char grade, boolean isActive)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.mobileNum = mobileNum;
        this.emailId = emailId;
        this.grade = grade;
        this.isActive = isActive;
    }

    @Override
    public String toString()
    {
        return "{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", salary=" + salary +
               ", mobileNum=" + mobileNum +
               ", emailId='" + emailId + '\'' +
               ", grade=" + grade +
               ", isActive=" + isActive +
               '}';
    }
}
