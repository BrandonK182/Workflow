package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.List;

public class CreateActivity extends AppCompatActivity {

    TextView etDate;
    TextView etTitle;
    TextView etClass;
    TextView etTime;
    TextView etDayOfWeek;
    Button btnSumbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etDayOfWeek = findViewById(R.id.etDayOfWeek);
        etDate = findViewById(R.id.etDate);
        etTitle = findViewById(R.id.etTitle);
        etClass = findViewById(R.id.etClass);
        etTime = findViewById(R.id.etTime);
        btnSumbit = findViewById(R.id.btnSubmit);

        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dayOfWeek = etDayOfWeek.getText().toString();
                String date = etDate.getText().toString();
                String title = etTitle.getText().toString();
                String className = etClass.getText().toString();
                String time = etTime.getText().toString();

                List<Day> days = Parcels.unwrap(getIntent().getParcelableExtra("days"));
                Day day = new Day(dayOfWeek,date);
                if(days.contains(day))
                {
                    Day day2 = days.get(days.indexOf(day));
                    day2.addAssignment(new Assignment(className, title, time));
                }
                else
                {

                }
            }
        });

    }
}