package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

import java.util.ArrayList;
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

        ArrayList<Integer> monthLengths = new ArrayList<>();
        monthLengths.add(00);
        monthLengths.add(31);
        monthLengths.add(29);
        monthLengths.add(31);
        monthLengths.add(30);
        monthLengths.add(31);
        monthLengths.add(30);
        monthLengths.add(31);
        monthLengths.add(31);
        monthLengths.add(30);
        monthLengths.add(31);
        monthLengths.add(30);
        monthLengths.add(31);

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

                if(dateMonth <= 12)
                {
                    if(dateDay <= monthLengths.get(dateMonth))
                    {
                        if(timeHour < 24)
                        {
                            if(timeMinute < 60)
                            {
                                Day day = new Day(dayOfWeek,dateMonth,dateDay);
                                Assignment assignment = new Assignment(className, title, timeHour,timeMinute);
                                Intent intent = new Intent();
                                intent.putExtra("newDay", Parcels.wrap(day));
                                intent.putExtra("newAssignment", Parcels.wrap(assignment));
                                setResult(RESULT_OK, intent);
                                Log.i(TAG,"reached end of click listener");
                                finish();
                            }
                            else{
                                Toast.makeText(CreateActivity.this,"CAN NOT HAVE TIME LONGER THAN 60 minutes", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(CreateActivity.this,"CAN NOT HAVE TIME LONGER THAN 24 HOURS", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(CreateActivity.this,"CAN NOT HAVE DAY LONGER THAN MONTH", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(CreateActivity.this,"CAN NOT HAVE MONTHS BEYOND 12th MONTH", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}