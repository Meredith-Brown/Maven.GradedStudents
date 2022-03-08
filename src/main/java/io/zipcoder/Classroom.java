package io.zipcoder;

public class Classroom {
    public Student[] students;
    public int maxNumberOfStudents;

    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
// students = new Student[maxNumberOfStudents]; --- this is functionally the same as ^^^, just written a
// different way
    }

    public Classroom(Student[] student){
        students = student;
    }

    public Classroom(){
        students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }
}
