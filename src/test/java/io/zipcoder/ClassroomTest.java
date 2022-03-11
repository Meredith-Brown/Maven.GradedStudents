package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {
    // Ensure positive and negative unit tests exist per feature of the application.
    // https://studiofreya.com/java/testing-java-with-junit/
    // A positive test is a test that verifies a correct functionality, a negative test verifies that
    // a function will fail or throw an exception.

    @Test
    public void constructorTest1() {
        // Given
        int maxNumberOfStudents = 30;
        Student[] students;
        // When
        Classroom classroom = new Classroom(maxNumberOfStudents);
        int actualMaxNumberOfStudents = classroom.maxNumberOfStudents;
        // Then
        Assert.assertEquals(maxNumberOfStudents, actualMaxNumberOfStudents);
    }

    @Test
    public void constructorTestNegative1() {
        // Given
        int maxNumberOfStudents = 30;
        Student[] students;
        // When
        Classroom classroom = new Classroom(maxNumberOfStudents);
        int actualMaxNumberOfStudents = classroom.maxNumberOfStudents;
        // Then
        Assert.assertNotEquals(25, actualMaxNumberOfStudents);
    }

    @Test
    public void constructorTest2() {
        // Given
        int expected = 26;
        Student[] studentsArray = new Student[expected];
        // When
        Classroom classroom = new Classroom(studentsArray);
        int actualMaxNumberOfStudents = classroom.students.length;
        // Then
        Assert.assertEquals(expected, actualMaxNumberOfStudents);
    }

    @Test
    public void constructorTestNegative2() {
        // Given
        int expected = 26;
        Student[] studentsArray = new Student[expected];
        // When
        Classroom classroom = new Classroom(studentsArray);
        int actualMaxNumberOfStudents = classroom.students.length;
        expected = 27;
        // Then
        Assert.assertNotEquals(expected, actualMaxNumberOfStudents);
    }

    @Test
    public void constructorTest3() {
        // Given
        int expectedArraySize = 30;
        // When
        Classroom classroom = new Classroom();
        int actualArraysize = classroom.students.length;
        // Then
        Assert.assertEquals(expectedArraySize, actualArraysize);
    }

    @Test
    public void constructorTestNegative3() {
        // Given
        int expectedArraySize = 30;
        // When
        Classroom classroom = new Classroom();
        int actualArraysize = classroom.students.length;
        expectedArraySize = 4;
        // Then
        Assert.assertNotEquals(expectedArraySize, actualArraysize);
    }

    @Test
    public void getStudentsTestPositive() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Double[] examsMike = {98.0, 99.0, 100.0};
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student studentMike = new Student("Mike", "Prentice", examsMike);
        Student[] student2Students = {studentMeredith, studentMike};
        Classroom classroom = new Classroom(student2Students);
        // When
        Student[] expected = student2Students;
        Student[] actual = classroom.getStudents();
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsTestNegative() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Double[] examsMike = {98.0, 99.0, 100.0};
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student studentMike = new Student("Mike", "Prentice", examsMike);
        Student[] student2Students = {studentMeredith, studentMike};
        Classroom classroom = new Classroom(student2Students);
        // When
        Student[] expected = {null, null};
        Student[] actual = classroom.getStudents();
        // Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoresPositiveTest() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Double[] examsMike = {98.0, 99.0, 100.0};
        Double[] examsNusera = {95.0, 96.0, 97.0};
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student studentMike = new Student("Mike", "Prentice", examsMike);
        Student studentNusera = new Student("Nusera", "Neha", examsNusera);
        Student[] student3Students = {studentMeredith, studentMike, studentNusera};
        Classroom classroom = new Classroom(student3Students);
        // When
        double expected = 98.0;
        double actual = classroom.getAverageExamScores();
        // Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void getAverageExamScoresNegativeTest() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Double[] examsMike = {98.0, 99.0, 100.0};
        Double[] examsNusera = {95.0, 96.0, 97.0};
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student studentMike = new Student("Mike", "Prentice", examsMike);
        Student studentNusera = new Student("Nusera", "Neha", examsNusera);
        Student[] student3Students = {studentMeredith, studentMike, studentNusera};
        Classroom classroom = new Classroom(student3Students);
        // When
        double expected = 97.0;
        double actual = classroom.getAverageExamScores();
        // Then
        Assert.assertNotEquals(expected, actual, 0.01);
    }

    @Test
    public void addStudentPositiveTest() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student[] arrayOfStudents = new Student[]{null};
        Classroom classroom = new Classroom(arrayOfStudents);
        // When
        classroom.addStudent(studentMeredith);
        Student[] returnArray = classroom.getStudents();
        Student actualStudent = returnArray[returnArray.length-1];
        // Then
        Assert.assertEquals(studentMeredith, actualStudent);
    }

    @Test
    public void addStudentNegativeTest() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Double[] examsNusera = {100.0, 99.0, 98.0};
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student studentNusera = new Student("Nusera", "Neha", examsNusera);
        Student[] arrayOfStudents = new Student[]{null};
        Classroom classroom = new Classroom(arrayOfStudents);
        // When
        classroom.addStudent(studentMeredith);
        Student[] returnArray = classroom.getStudents();
        Student actualStudent = returnArray[returnArray.length-1];
        // Then
        Assert.assertNotEquals(studentNusera, actualStudent);
    }

    @Test
    public void removeStudentPositiveTest() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Double[] examsMike = {98.0, 99.0, 100.0};
        Double[] examsNusera = {95.0, 96.0, 97.0};
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student studentMike = new Student("Mike", "Prentice", examsMike);
        Student studentNusera = new Student("Nusera", "Neha", examsNusera);
        Student[] student3Students = {studentMeredith, studentMike, studentNusera};
        Classroom classroom = new Classroom(student3Students);
        // When
        classroom.removeStudent("Meredith", "Brown");
        // Then
        Assert.assertFalse(Arrays.asList(classroom.students).contains(studentMeredith));
    }

    @Test
    public void removeStudentNegativeTest() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Double[] examsMike = {98.0, 99.0, 100.0};
        Double[] examsNusera = {95.0, 96.0, 97.0};
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student studentMike = new Student("Mike", "Prentice", examsMike);
        Student studentNusera = new Student("Nusera", "Neha", examsNusera);
        Student[] student3Students = {studentMeredith, studentMike, studentNusera};
        Classroom classroom = new Classroom(student3Students);
        // When
        classroom.removeStudent("Meredith", "Brown");
        // Then
        Assert.assertTrue(!Arrays.asList(classroom.students).contains(studentMeredith));
    }

    @Test
    public void getStudentsByScorePositiveTest() {
        // Given
        Double[] examsMeredith = {100.0, 99.0, 98.0};
        Double[] examsMike = {99.0, 98.0, 97.0};
        Double[] examsNusera = {95.0, 96.0, 97.0};
        Double[] examsYun = {95.0, 96.0, 97.0};
        Student studentNusera = new Student("Nusera", "Neha", examsNusera);
        Student studentYun = new Student("Yun", "Cho", examsYun);
        Student studentMeredith = new Student("Meredith", "Brown", examsMeredith);
        Student studentMike = new Student("Mike", "Prentice", examsMike);
        Student[] student4Students = {studentNusera, studentYun, studentMeredith, studentMike};
        Classroom classroom = new Classroom(student4Students);
        // When
        Student[] expectedArray = {studentMeredith, studentMike,studentNusera, studentYun};
        Student[] actualArray = classroom.getStudentsByScore();
        // Then
        Assert.assertEquals(expectedArray, actualArray);
    }
}
