package com.example.workflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvDay;
    List<Day> days;
    DayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDay = findViewById(R.id.rvDays);
        days = new ArrayList<>();
        adapter = new DayAdapter(this, days);
        //Recycler view setup: layout manager and the adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvDay.setLayoutManager(layoutManager);
        rvDay.setAdapter(adapter);
        days.add(new Day());
        adapter.notifyDataSetChanged();
    }

}