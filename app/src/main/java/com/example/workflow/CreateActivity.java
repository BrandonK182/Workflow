package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.List;

public class CreateActivity extends AppCompatActivity {

    static final String TAG = "CreateActivity";

    TextView etDate;
    TextView etTitle;
    TextView etClass;
    TextView etTime;
    TextView etDayOfWeek;
    Button btnSumbit;
    TextView etDateDay;
    TextView etTimeMin;

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
        etDateDay = findViewById(R.id.etDateDay);
        etTimeMin = findViewById(R.id.etTimeMin);

        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dayOfWeek = etDayOfWeek.getText().toString();
                String date = etDate.getText().toString();
                String title = etTitle.getText().toString();
                String className = etClass.getText().toString();
                String time = etTime.getText().toString();
                String dateStringDay = etDateDay.getText().toString();
                String timeMin = etTimeMin.getText().toString();
                int dateMonth = Integer.parseInt(date);
                int dateDay = Integer.parseInt(dateStringDay);
                int timeHour = Integer.parseInt(time);
                int timeMinute = Integer.parseInt(timeMin);

                Day day = new Day(dayOfWeek,dateMonth,dateDay);
                Assignment assignment = new Assignment(className, title, timeHour,timeMinute);
                Intent intent = new Intent();
                intent.putExtra("newDay", Parcels.wrap(day));
                intent.putExtra("newAssignment", Parcels.wrap(assignment));
                setResult(RESULT_OK, intent);
                Log.i(TAG,"reached end of click listener");
                finish();
            }
        });

    }
}