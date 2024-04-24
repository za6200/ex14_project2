package com.example.ex14_project2;

public class Student {
    private String name;
    private String lastName;
    private String iD1;
    private String grade;
    private String classNumber;
    private Boolean canVaccine;
    private Boolean firstVaccine;
    private Boolean secondVaccine;

    public Student(String name, String lastName, String iD1, String grade, String classNumber,
                   Boolean canVaccine, Boolean firstVaccine, Boolean secondVaccine) {
        this.name = name;
        this.lastName = lastName;
        this.iD1 = iD1;
        this.grade = grade;
        this.classNumber = classNumber;
        this.canVaccine = canVaccine;
        this.firstVaccine = firstVaccine;
        this.secondVaccine = secondVaccine;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setID1(String iD1) {
        this.iD1 = iD1;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public void setCanVaccine(Boolean canVaccine) {
        this.canVaccine = canVaccine;
    }

    public void setFirstVaccine(Boolean firstVaccine) {
        this.firstVaccine = firstVaccine;
    }

    public void setSecondVaccine(Boolean secondVaccine) {
        this.secondVaccine = secondVaccine;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID1() {
        return iD1;
    }

    public String getGrade() {
        return grade;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public Boolean getCanVaccine() {
        return canVaccine;
    }

    public Boolean getFirstVaccine() {
        return firstVaccine;
    }

    public Boolean getSecondVaccine() {
        return secondVaccine;
    }

}
