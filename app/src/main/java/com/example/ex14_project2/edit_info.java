package com.example.ex14_project2;

import static com.example.ex14_project2.FBref.refStudents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class edit_info extends AppCompatActivity {

    TextView Name, Last_Name, Grade, Class_Number, iD1, vaccine_site, vaccine_date;
    Switch Can_Vaccine, First_Vaccine, Second_Vaccine;
    Student student;
    vaccinate vaccinate;
    ArrayList<String> stuList = new ArrayList<String>();
    ArrayList<Student> stuValues = new ArrayList<Student>();
    Intent edit, fetures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
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
        edit = getIntent();
        fetures = new Intent(this, fetures.class);
        add();
    }
    public void add()
    {
        ValueEventListener stuListener = new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dS) {
                stuList.clear();
                stuValues.clear();
                for(DataSnapshot data : dS.getChildren()) {
                    String id_stud = data.getKey();
                    if(id_stud.equals(edit.getStringExtra("stu_id")))
                    {
                        Student stuTmp = data.getValue(Student.class);
                        Name.setText(stuTmp.getName());
                        Last_Name.setText(stuTmp.getLastName());
                        iD1.setText(stuTmp.getID1());
                        Grade.setText(stuTmp.getGrade());
                        Class_Number.setText(stuTmp.getClassNumber());
                        Can_Vaccine.setChecked(stuTmp.getCanVaccine());
                        First_Vaccine.setChecked(stuTmp.getFirstVaccine());
                        Second_Vaccine.setChecked(stuTmp.getSecondVaccine());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        };
        refStudents.addValueEventListener(stuListener);
    }
    public void sendToDB() {
        student.setName(Name.getText().toString());
        student.setLastName(Last_Name.getText().toString());
        student.setGrade(Grade.getText().toString());
        student.setClassNumber(Class_Number.getText().toString());
        student.setID1(iD1.getText().toString());
        student.setCanVaccine(Boolean.valueOf(Can_Vaccine.isChecked()));
        student.setFirstVaccine(Boolean.valueOf(First_Vaccine.isChecked()));
        student.setSecondVaccine(Boolean.valueOf(Second_Vaccine.isChecked()));
        student.setID1(iD1.getText().toString());

        // Instantiate the vaccinate object
        vaccinate = new vaccinate("", "");
        vaccinate.setVaccine_site(vaccine_site.getText().toString());
        vaccinate.setVaccine_date(vaccine_date.getText().toString());

        // Create a map to hold both student and vaccinate data
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("student", student);
        dataMap.put("vaccinate", vaccinate);

        refStudents.child(student.getGrade()).child(student.getClassNumber()).child(student.getID1()).setValue(dataMap);
    }
    public void next2(View view) {
        if (!(Can_Vaccine.isChecked() && (First_Vaccine.isChecked() || Second_Vaccine.isChecked())))
        {
            Toast.makeText(getApplicationContext(), "Cannot Vaccinate", Toast.LENGTH_SHORT).show();
        }
        else if (!(First_Vaccine.isChecked()) && Second_Vaccine.isChecked())
        {
            Toast.makeText(getApplicationContext(), "Do first vaccine first", Toast.LENGTH_SHORT).show();
        }
        else
        {
            sendToDB();
            startActivity(fetures);
        }
    }
}