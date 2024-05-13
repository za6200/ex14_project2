package com.example.ex14_project2;

import static com.example.ex14_project2.FBref.refStudents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class info_input extends AppCompatActivity {
    TextView Name, Last_Name, Grade, Class_Number, iD1, vaccine_site, vaccine_date;
    Switch Can_Vaccine, First_Vaccine, Second_Vaccine;
    Student student;
    vaccinate vaccinate;
    Intent edit, credits, input;

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
        edit = new Intent(this, edit_info.class);
        input = new Intent(this, info_input.class);
        credits = new Intent(this, credits.class);

        student = new Student("", "", "", "", "", false, false, false);
        // Instantiate the vaccinate object
        vaccinate = new vaccinate("", "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * function will make the option menu
         * param menu: the menu
         */
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        /**
         * function will check if the user clicked the credit button and if he did it will get him to the credits screen
         * param item: the item clicked
         */
        String st = item.getTitle().toString();
        if(st.equals("edit"))
        {
            startActivity(edit);
        }
        else if(st.equals("credit"))
        {
            startActivity(credits);
        }
        else if(st.equals("input"))
        {
            startActivity(input);
        }
        return super.onOptionsItemSelected(item);
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

        vaccinate.setVaccine_site(vaccine_site.getText().toString());
        vaccinate.setVaccine_date(vaccine_date.getText().toString());

        // Create a map to hold both student and vaccinate data
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("student", student);
        dataMap.put("vaccinate", vaccinate);

        refStudents.child(student.getGrade()).child(student.getClassNumber()).child(student.getID1()).setValue(dataMap);
    }

    public void next(View view) {
        if ((!(Can_Vaccine.isChecked()) && (First_Vaccine.isChecked() || Second_Vaccine.isChecked())))
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
            edit.putExtra("name", student.getName());
            edit.putExtra("lastName", student.getLastName());
            edit.putExtra("id", student.getID1());
            edit.putExtra("grade", student.getGrade());
            edit.putExtra("classNumber", student.getClassNumber());
            edit.putExtra("canVaccine", student.getCanVaccine());
            edit.putExtra("firstVaccine", student.getFirstVaccine());
            edit.putExtra("secondVaccine", student.getSecondVaccine());
            edit.putExtra("vaccineSite", vaccinate.getVaccine_site());
            edit.putExtra("vaccineDate", vaccinate.getVaccine_date());

            startActivity(edit);
        }
    }
}