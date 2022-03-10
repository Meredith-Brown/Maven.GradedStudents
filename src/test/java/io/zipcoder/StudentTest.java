package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class StudentTest {
    // Ensure positive and negative unit tests exist per feature of the application.
    // https://studiofreya.com/java/testing-java-with-junit/
    // A positive test is a test that verifies a correct functionality,
    // a negative test verifies that a function will fail or throw an exception.

    @Test // for framework -- called an annotation
    public void constructorTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        // When
        Student student = new Student(firstName, lastName, examScores);
        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();
        ArrayList<Double> actualExamScores = student.getExamScoresAsArrayList();
        // Then
        Assert.assertEquals(firstName, actualFirstName);
        Assert.assertEquals(lastName, actualLastName);
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void constructorTestNegative() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        // When
        Student student = new Student(firstName, lastName, examScores);
        String actualFirstName = "Naomi";
        String actualLastName = "Winkelmayer";
        ArrayList<Double> actualExamScores = new ArrayList<>(5);
        // Then
        Assert.assertFalse(Objects.equals(firstName, actualFirstName));
        Assert.assertFalse(Objects.equals(lastName, actualLastName));
        Assert.assertFalse(Objects.equals(expectedExamScores, actualExamScores));
    }

    @Test
    public void setGetFirstNameTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, examScores);
        // When
        String expectedFirstName = "Naomi";
        student.setFirstName(expectedFirstName);
        // Then
        String actualFirstName = student.getFirstName();
        Assert.assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    public void setGetFirstNameTestNegative() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, examScores);
        // When
        student.setFirstName(firstName);
        // Then
        String actualFirstName = student.getFirstName();
        Assert.assertFalse(Objects.equals("Naomi", actualFirstName));
    }

    @Test
    public void setGetLastNameTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, examScores);
        // When
        student.setLastName(lastName);
        // Then
        String actualLastName = student.getLastName();
        Assert.assertEquals(lastName, actualLastName);
    }

    @Test
    public void setGetLastNameTestNegative() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, examScores);
        // When
        student.setLastName(lastName);
        // Then
        String actualLastName = student.getLastName();
        Assert.assertNotEquals("Winkelmayer", actualLastName);
    }

    @Test
    public void getNumberOfExamsTakenTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        // When
        Student student = new Student(firstName, lastName, examScores);
        int actualNumberOfExamsTaken = student.getNumberOfExamsTaken();
        // Then
        Assert.assertEquals(examScores.length, actualNumberOfExamsTaken);
    }

    @Test
    public void getNumberOfExamsTakenTestNegative() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        // When
        Student student = new Student(firstName, lastName, examScores);
        int actualNumberOfExamsTaken = student.getNumberOfExamsTaken();
        // Then
        Assert.assertNotEquals(examScores.length - 1, actualNumberOfExamsTaken);
    }

    @Test
    public void getExamsScoresTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        String expectedOutput = "Exam Scores:" + "\n" + "Exam 1 -> 100.0" + "\n" + "Exam 2 -> 90.0" +
                "\n" + "Exam 3 -> 80.0" + "\n" + "Exam 4 -> 70.0" + "\n" + "Exam 5 -> 60.0" + "\n";
        // When
        Student student = new Student(firstName, lastName, examScores);
        String actualOutput = student.getExamScores();
        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getExamsScoresTestNegative() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        String expectedOutput = "Exam Scores:" + "\n" + "Exam 1 -> 100.0" + "\n" + "Exam 2 -> 80.0" +
                "\n" + "Exam 3 -> 90.0" + "\n" + "Exam 4 -> 70.0" + "\n" + "Exam 5 -> 60.0" + "\n";
        // When
        Student student = new Student(firstName, lastName, examScores);
        String actualOutput = student.getExamScores();
        // Then
        Assert.assertNotEquals(expectedOutput, actualOutput);
    }

    @Test
    public void addExamScoreTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double newExamScore = 50.0;
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        // When
        Student student = new Student(firstName, lastName, examScores);
        student.addExamScore(newExamScore);
        // Then
        Assert.assertEquals(newExamScore, student.examScores.get(examScores.length));
    }

    @Test
    public void addExamScoreTestNegative() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double newExamScore = 50.0;
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        // When
        Student student = new Student(firstName, lastName, examScores);
        student.addExamScore(newExamScore);
        newExamScore += 5;
        // Then
        Assert.assertNotEquals(newExamScore, student.examScores.get(examScores.length - 1));
    }

    @Test
    public void setExamScoreTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double newExamScore = 35.0;
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        // When
        Student student = new Student(firstName, lastName, examScores);
        student.setExamScore(1, newExamScore);
        // Then
        Assert.assertEquals(newExamScore, student.examScores.get(0));
    }

    @Test
    public void getAverageExamScoreTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double expectedOutput = 80.0;
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        // When
        Student student = new Student(firstName, lastName, examScores);
        Double actualOutput = student.getAverageExamScore();
        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void toStringTestPositive() {
        // Given
        String firstName = "Meredith";
        String lastName = "Brown";
        Double[] examScores = {100.0, 90.0, 80.0, 70.0, 60.0};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        String expectedOutput = "Student Name: Meredith Brown" + "\n" + "> Average Score: 80.0" + "\n"
                + "> Exam Scores: " + "\n" + "Exam 1 -> 100.0" + "\n" + "Exam 2 -> 90.0" + "\n" +
                "Exam 3 -> 80.0" + "\n" + "Exam 4 -> 70.0" + "\n" + "Exam 5 -> 60.0" + "\n";
        // When
        Student student = new Student(firstName, lastName, examScores);
        String actualOutput = student.toString();
        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}