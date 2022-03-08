package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    public String firstName;
    public String lastName;
    public ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getExamScoresAsArrayList() {
        return examScores;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exam Scores:");
        sb.append("\n");
        for (int i = 0; i < examScores.size(); i++) {
            sb.append("Exam " + (i+1) + " -> " + examScores.get(i));
            sb.append("\n");
        }
        String output = sb.toString();
        return output;
    }

    public String addExamScore(Double examScore) {
        examScores.add(examScore);
        int examNumber = examScores.size();
        String output = "";
        output += "Exam Scores:" + "\n" + "Exam " + examNumber + " -> " + examScore;
        return output;
    }

    public String setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
        String output = "";
        output += "Exam Scores:" + "\n" + "Exam " + examNumber + " -> " + newScore;
        return output;
    }

    public Double getAverageExamScore() {
        double sum = 0;
        double size = examScores.size();
        for(int i = 0; i < size; i++) {
            sum += examScores.get(i);
        }
        double output = sum / size;
        return output;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Double averageScore = getAverageExamScore();
        sb.append("Student Name: " + firstName + " " + lastName);
        sb.append("\n");
        sb.append("> Average Score: ");
        sb.append(averageScore);
        sb.append("\n");
        sb.append("> Exam Scores: ");
        sb.append("\n");
        for (int i = 0; i < examScores.size(); i++) {
            sb.append("Exam " + (i+1) + " -> " + examScores.get(i));
            sb.append("\n");
        }
        String output = sb.toString();
        return output;
    }
}
