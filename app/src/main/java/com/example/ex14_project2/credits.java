package com.example.ex14_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    TextView textView;
    Intent features, edit;
    Intent credits, input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        textView = findViewById(R.id.textView);
        edit = new Intent(this, edit_info.class);
        input = new Intent(this, info_input.class);
        credits = new Intent(this, credits.class);

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

}