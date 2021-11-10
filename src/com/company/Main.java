package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void runApp() throws FileNotFoundException {
        boolean quit = false;
        RecordCatalogue rc = new RecordCatalogue();
        rc.loadStudents();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to print all students."
                + "\n"
                + "Enter 2 to print a specific student."
                + "\n"
                + "Enter 3 to print highest grade."
                + "\n"
                + "Enter 4 to print lowest grade."
                + "\n"
                + "Enter 5 to print average grade."
                + "\n"
                + "Enter 6 to quit.");
        while(!quit){
            try {
                int x = Integer.parseInt(sc.next());
                switch (x){
                    case 1:
                        rc.printStudents();
                        break;
                    case 2:
                        System.out.println("Enter name of student");
                        if(sc.hasNext()){
                            rc.printSpecificStudent(sc.next());
                        }
                        break;
                    case 3:
                        rc.highestGrade();
                        break;
                    case 4:
                        rc.lowestGrade();
                        break;
                    case 5:
                        rc.averageGrades();
                        break;
                    case 6:
                        System.out.println("Quiting...");
                        quit = true;
                        break;
                    default:
                        System.out.println("You have to enter a number between 1-6");
                        break;
                }
            }catch(NumberFormatException e) {
                System.out.println("input is not an int value");
            }


            }
        }


    public static void main(String[] args) throws FileNotFoundException {
        runApp();


    }
}
