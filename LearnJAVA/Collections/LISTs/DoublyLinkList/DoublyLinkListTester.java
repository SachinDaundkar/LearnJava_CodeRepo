/*
 * COPYRIGHT (C) 2016 Sachin Daundkar. All Rights Reserved.
 */

package com.LearnJAVA.Collections.LISTs.DoublyLinkList;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by sachin on 15-06-2016.
 */
public class DoublyLinkListTester
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        DoublyLinkList<String> dll = new DoublyLinkList<String>();
        System.out.println("Menu: \n1. Add First\n2. Add Last\n3. Remove First\n4. Remove Last\n5. Exit\n");
        int flag = 0;
            while (scan.hasNextLine() && flag !=-1)
            {
                try
                {
                    switch (scan.nextInt())
                    {
                        case 1:
                            scan.nextLine();
                            System.out.println("Enter data to add in a First node=> ");
                            dll.addFirst(scan.nextLine());
                            break;
                        case 2:
                            scan.nextLine();
                            System.out.println("Enter data to add in a last node=> ");
                            dll.addLast(scan.nextLine());
                            break;
                        case 3:
                            scan.nextLine();
                            System.out.println("First node is removed, Its Data = "+ dll.removeFirst());
                            break;
                        case 4:
                            scan.nextLine();
                            System.out.println("Last node is removed, Its Data = "+ dll.removeLast());
                            break;
                        case 5:
                            System.out.println("Exiting ...");
                            flag = -1;
                            break;
                        default:
                            scan.nextLine();
                            System.out.println("Input is not recognised");
                            break;
                    }
                System.out.println("Link List after your operation is => \n" + dll.toString());
                } catch (InputMismatchException IME) {
                    scan.nextLine();
                    System.out.println("Input is not recognised");
                    System.out.println("Link List after your operation is => \n" + dll.toString());
                }
                catch (NoSuchElementException NSEE) {
                    System.out.println("Operation is illegal to perform");
                    System.out.println("Link List after your operation is => \n" + dll.toString());
                }
                catch (NullPointerException NPE) {
                    System.out.println("Link List after your operation is => \n" + dll.toString());
                }
            }

    }
}
