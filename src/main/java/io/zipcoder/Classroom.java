package io.zipcoder;

import java.util.*;

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

    public double getAverageExamScores() {
        double numberOfStudents = students.length;
        double sumOfAverages = 0;
        for(Student s : students){
            sumOfAverages += s.getAverageExamScore();
        }
        return sumOfAverages / numberOfStudents;
    }

    public String addStudent(Student student) {
        for(int i = 0; i < students.length; i++) { // https://stackoverflow.com/questions/25918532/adding-an-element-to-the-first-empty-arrays-index
            if(students[i] == null) {
               students[i] = student;
               break;
            }
        }
        String output = student.toString();
        return output;
    }

    public void removeStudent(String firstName, String lastName) { // method assumes only 1 person w/ that first and last name
        int length = students.length;
        int index = 0;
        for(int i = 0; i < students.length; i++) {
            if (Objects.equals(students[i].getFirstName(), firstName) && Objects.equals(students[i].getLastName(), lastName)) {
                students[i] = null;
                index = i;
            }
        }
        for (int i2 = index; i2 < students.length-1; i2++) {
            students[i2] = students[i2+1];
            }
        students[length-1] = null;
        }

    public Student[] getStudentsByScore() {
        Student temporary;
        List<Student> sortedStudentList = Arrays.asList(students);
        for (int i = 0; i < sortedStudentList.size() - 1; i++) {
            if (sortedStudentList.get(i).getAverageExamScore() < sortedStudentList.get(i+1).getAverageExamScore()) {
                temporary = sortedStudentList.get(i);
                sortedStudentList.set(i, sortedStudentList.get(i+1));
                sortedStudentList.set(i+1, temporary);
                i--;
            } else if (Objects.equals(students[i].getAverageExamScore(), students[i+1].getAverageExamScore())) {
                // if equal - sort by last name, if equal - sort by first name
            } else {

            }
        }
        return null;
    }

    public HashMap<Student, String> getGradeBook() { // HashMaps: https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
            int percentileSize = students.length / 10;
            Student[] sortedStudentList = getStudentsByScore(); // last name might determine grade based on above...
            HashMap<Student, String> gradeBook = new HashMap<>();
            for(int i = 0; i < students.length; i++) {
                if (i > 0 && i < percentileSize - 1) {
                    gradeBook.put(sortedStudentList[i], "A");
                } else if (i > percentileSize - 1 && i < percentileSize * 2 - 1) {
                    gradeBook.put(sortedStudentList[i], "B");
                } else if (i > percentileSize * 2 - 1 && i < percentileSize * 3 - 1) {
                    gradeBook.put(sortedStudentList[i], "C");
                } else if (i > percentileSize * 3 - 1 && i < percentileSize * 4 - 1) {
                    gradeBook.put(sortedStudentList[i], "D");
                } else {
                    gradeBook.put(sortedStudentList[i], "F");
                }
            }
            return gradeBook;
        }
}
