/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Inheritance.MultiInheritanceDemo;

/**
 * Created by sachin on 16-06-2016.
 */
public class StudentStaffMultiInheritance extends Student implements Staff
{

    public static void main (String [] args)
    {
        StaffImpl SI = new StaffImpl();
        Student S = new Student();
        System.out.println(SI.getSalary());
        System.out.println(S.getGPA());

        StudentStaffMultiInheritance SS = new StudentStaffMultiInheritance();
        System.out.println(SS.getSalary());
        System.out.println(SS.getGPA());

        Staff sf = new StaffImpl();
        System.out.println(sf.getSalary());

    }
    @Override
    public String getSalary()
    {
        return "StudentStaffMultiInheritance getSalary ";
    }
}

class Student
{
    public String getGPA()
    {
        return "Student GPA Method called";
    }
}

interface Staff
{
    public String getSalary();
}
class StaffImpl implements Staff
{

    @Override
    public String getSalary()
    {
        return "Staff Impl get Salary Method Called ";
    }
}
