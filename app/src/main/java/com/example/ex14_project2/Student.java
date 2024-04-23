package com.example.ex14_project2;

public class Student {
    private String name;
    private String lastName;
    private String iD1;
    private String grade;
    private String classNumber;
    private String canVaccine;
    private String firstVaccine;
    private String secondVaccine;
    private String vaccine_site;
    private String vaccine_date;

    public Student(String name, String lastName, String iD1, String grade, String classNumber,
                   String canVaccine, String firstVaccine, String secondVaccine, String vaccine_site, String vaccine_date) {
        this.name = name;
        this.lastName = lastName;
        this.iD1 = iD1;
        this.grade = grade;
        this.classNumber = classNumber;
        this.canVaccine = canVaccine;
        this.firstVaccine = firstVaccine;
        this.secondVaccine = secondVaccine;
        this.vaccine_site = vaccine_site;
        this.vaccine_date = vaccine_date;
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

    public void setCanVaccine(String canVaccine) {
        this.canVaccine = canVaccine;
    }

    public void setFirstVaccine(String firstVaccine) {
        this.firstVaccine = firstVaccine;
    }

    public void setSecondVaccine(String secondVaccine) {
        this.secondVaccine = secondVaccine;
    }
    public void setVaccine_site(String vaccine_site)
    {
        this.vaccine_site = vaccine_site;
    }
    public void setVaccine_date(String vaccine_date)
    {
        this.vaccine_date = vaccine_date;
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

    public String getCanVaccine() {
        return canVaccine;
    }

    public String getFirstVaccine() {
        return firstVaccine;
    }

    public String getSecondVaccine() {
        return secondVaccine;
    }
    public String getVaccine_site()
    {
        return vaccine_site;
    }
    public String getVaccine_date()
    {
        return vaccine_date;
    }
}
