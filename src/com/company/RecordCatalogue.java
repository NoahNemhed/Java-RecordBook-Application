package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RecordCatalogue {
    private List<Student> studentList;


    //Constructor initialize studentList.
    public RecordCatalogue() {
        studentList = new ArrayList<>();
    }

    //Returns a list of students.
    public List<Student> getStudentList() {
        return studentList;
    }
    // method to add a to the list.
    public void addStudent(Student student){
        studentList.add(student);
    }
    //Loops through the studentlist and prints every student with its states
    public void printStudents(){
        for(Student s : getStudentList()){
            System.out.println("Name : " + s.getName()
                    + ". Age : " + s.getAge()
                    + ". Grade : " + s.getRecordBook().getGrade()
                    + ". Id : " + s.getId());
        }
    }
    //Sorting the list from highest to lowest and printing the highest grade in class
    public void highestGrade(){
        List<Integer> Grades = new ArrayList<>();
        for(Student s : studentList){
            Grades.add(Integer.parseInt(s.getRecordBook().getGrade()));
        }
        Collections.sort(Grades);
        int temp = (Grades.size()-1);
        String gradeToFind = Grades.get(temp).toString();
        for(Student s : studentList){
            if(s.getRecordBook().getGrade().equals(gradeToFind)){
                System.out.println("Highest grade in RecordCatalogue : " +
                        "Name : " + s.getName()
                        + ". Age : " + s.getAge()
                        + ". Grade : " + s.getRecordBook().getGrade()
                        + ". Id : " + s.getId());
            }
        }
    }
    //Sorting the list from highest to lowest and printing the highest grade in class
    public void lowestGrade(){
        List<Integer> Grades = new ArrayList<>();
        for(Student s : studentList){
            Grades.add(Integer.parseInt(s.getRecordBook().getGrade()));
        }
        Collections.sort(Grades);
        int temp = 0;
        String gradeToFind = Grades.get(temp).toString();
        for(Student s : studentList){
            if(s.getRecordBook().getGrade().equals(gradeToFind)){
                System.out.println("Lowest grade in RecordCatalogue : " +
                        "Name : " + s.getName()
                        + ". Age : " + s.getAge()
                        + ". Grade : " + s.getRecordBook().getGrade()
                        + ". Id : " + s.getId());
            }
        }
    }
    //Uses findstudent() if return is not equal to -1 it will print the student.
    public void printSpecificStudent(String name){
        if(findStudent(name) != -1){
            System.out.println(studentList.get(findStudent(name)));
        }else{
            System.out.println("No student with name : " + name + " were found.");
        }
    }

    //Searches for a student in studentlist and if found returns the index in list.
    public int findStudent(String name){

        int count = 0;
        for(Student s : studentList){
            if(s.getName().equals(name)){
                return count;
            }
            count +=1;
        }
        return -1;
    }
    //Counts the average grade in recordBook and prints.
    public void averageGrades(){
        int size = studentList.size();
        double sum = 0;
        for(Student s : studentList){
            sum += Integer.parseInt(s.getRecordBook().getGrade());
        }
        System.out.println("The average grade in class is " + sum/size);
    }

    //Reads a text file and creates students from text file.
    public void loadStudents() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\noahn\\IdeaProjects\\RecordBookApplication\\src\\com\\company\\Students"));
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            RecordBook recordBook = new RecordBook(s[0]);
            String name = s[1];
            String id = s[2];
            int age = Integer.parseInt(s[3]);
            Student student = new Student(recordBook, name, id, age);
            addStudent(student);
        }
        sc.close();
    }


}
