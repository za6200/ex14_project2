package com.example.ex14_project2;

import static com.example.ex14_project2.FBref.refStudents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class info_input extends AppCompatActivity {
    TextView Name, Last_Name, Grade, Class_Number, iD1, vaccine_site, vaccine_date;
    Switch Can_Vaccine, First_Vaccine, Second_Vaccine;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_input);
        Name = findViewById(R.id.Name);
        Last_Name = findViewById(R.id.LastName);
        iD1 = findViewById(R.id.iD1);
        Grade = findViewById(R.id.Grade);
        Class_Number = findViewById(R.id.Class_Number);
        Can_Vaccine = findViewById(R.id.Can_Vaccine);
        First_Vaccine = findViewById(R.id.First_Vaccine);
        Second_Vaccine = findViewById(R.id.Second_Vaccine);
        vaccine_site = findViewById(R.id.vaccine_site);
        vaccine_date = findViewById(R.id.vaccine_date);

        student = new Student("", "", "", "", "", "", "", "", "", "");


    }

    public void sendToDB() {
        student.setName(Name.getText().toString());
        student.setLastName(Last_Name.getText().toString());
        student.setGrade(Grade.getText().toString());
        student.setClassNumber(Class_Number.getText().toString());
        student.setID1(iD1.getText().toString());
        student.setCanVaccine(String.valueOf(Can_Vaccine.isChecked()));
        student.setFirstVaccine(String.valueOf(First_Vaccine.isChecked()));
        student.setSecondVaccine(String.valueOf(Second_Vaccine.isChecked()));
        student.setID1(iD1.getText().toString());
        student.setVaccine_site(vaccine_site.getText().toString());
        student.setVaccine_date(vaccine_date.getText().toString());

        refStudents.child(student.getGrade()).child(student.getClassNumber()).child(student.getID1()).setValue(student);
    }


    public void next(View view) {
        sendToDB();

    }
}