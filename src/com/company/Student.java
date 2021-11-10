package com.company;

public class Student {
    private RecordBook recordBook;
    private String name;
    private String id;
    private int age;


    public Student(RecordBook recordBook, String name, String id, int age) {
        this.recordBook = recordBook;
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return("Name : " + getName()
                + ". Age : " + getAge()
                + ". Grade : " + getRecordBook().getGrade()
                + ". Id : " + getId());

    }

    //Getters for student.
    public RecordBook getRecordBook() {
        return recordBook;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
