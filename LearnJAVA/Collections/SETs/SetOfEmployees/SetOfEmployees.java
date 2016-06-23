/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.SETs.SetOfEmployees;

import java.util.*;

/**
 * Created by sachin on 12-06-2016.
 * Problem Statement:
 * Create a class of Employee having fields name, employeeId and salary.
 Create objects of employee class and store them in set. All employee should be unique by their empId. Make sure that employeeId should be between 1 - 1000. Sort collection on employee salary and print it in descending order.

 */
class Employee
{
    private TreeSet<Employee> employees = new TreeSet<>(BY_EMP_SALARY);
    public static final Comparator<Employee> BY_EMP_SALARY = Comparator.comparing(Employee::getSalary);
    private String name;
    private int employeeID;
    private double salary;

    public Set<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(TreeSet<Employee> employees) {
        this.employees = employees;
    }
    public Employee(String name, int employeeID,double salary)
    {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode()
    {
        //return super.hashCode();
        return Objects.hash(employeeID,name);
    }

    @Override
    public boolean equals(Object obj)
    {
        System.out.println("Inside equals method");
         super.equals(obj);
        if (obj == this) {    return true;    }
        if (!(obj instanceof Employee)) {    return false;     }

        Employee emp = (Employee) obj;
        return Objects.equals(this.employeeID,emp.employeeID);
        //return Integer.compare(employeeID, emp.employeeID) == 0;
    }

    @Override
    public String toString()
    {
        return "\nEmployee Name: " + this.name + ", Employee ID: " + this.employeeID + ", Employee Salary: " + this.salary ;
    }

    public void addNewEmployee(final Employee empToAdd)
    {
        if (empToAdd.getEmployeeID() > 1000 || empToAdd.getEmployeeID() < 1)
        {
            throw new IllegalStateException("Employee EMP ID valid range is (1 - 1000) ");
        }
        if (employees.contains(empToAdd)) {
            throw new IllegalStateException("Employee with same EMP ID "+empToAdd.employeeID+" already exists.");
        }
        employees.add(empToAdd);
    }
    public Employee()
    {
        this.employeeID = 0;
        this.name = "Default name";
        this.salary = 0d;
    }

    public Set<Employee> empInDescendingOrderOfSalary()
    {
        return this.employees.descendingSet();
    }
}

public class SetOfEmployees
{

    public static void main (String [] args)
    {
       // Set<Employee> employees = new TreeSet<>(BY_EMPID);
        Scanner scan = new Scanner(System.in);
        String empName;
        int empID;
        double empSalary;
        Employee employees = new Employee();
        do
        {
            try
            {
                System.out.println("Enter Employee Name: ");
                empName = scan.nextLine();
                System.out.println("Enter Employee Employee ID : ");
                empID = scan.nextInt();
                System.out.println("Enter Employee Salary: ");
                empSalary = scan.nextDouble();
                /*employees = new Employee(empName, empID, empSalary); */
                employees.addNewEmployee(new Employee(empName, empID, empSalary));
            }catch (InputMismatchException IME)
            {
                System.out.println("You have entered data in incorrect format");
                continue;
            }
            catch (IllegalStateException ISE)
            {
                System.out.println(ISE.getMessage());
                continue;
            }
            scan.nextLine();
            System.out.println("Do you want to continue adding more employee records: (N/n to exit) ");
        } while (!scan.nextLine().equalsIgnoreCase("n"));

        System.out.println("You have entered information of following employees -> \n " + employees.getEmployees() + "\n");

        System.out.println("Employees in descending sorted order of salary => \n " + employees.empInDescendingOrderOfSalary());
    }
}
