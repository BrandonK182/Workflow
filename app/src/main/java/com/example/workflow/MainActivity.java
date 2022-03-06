package com.example.workflow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "Main";

    RecyclerView rvDay;
    List<Day> days;
    DayAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_make_assignment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.create)
        {
            Intent i = new Intent(this, CreateActivity.class);
            i.putExtra("days", Parcels.wrap(days));
            startActivityForResult(i,20);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        Log.i(TAG,"beginning return");
        if(resultCode == RESULT_OK){
            Day day = Parcels.unwrap(data.getParcelableExtra("newDay"));
            //Pass relevant data back
            // Modify data source of tweets
            boolean found = false;
            int location = 0;
            for(int i = 0; i<days.size(); i++)
            {
                if(days.get(i).equals(day)){
                    found = true;
                    location = i;
                }
            }
            Log.i(TAG,"done search");
            if(!found){
                Log.i(TAG,"adding new day");
                location = days.size();
                days.add(day);
            }
            Assignment assignment = Parcels.unwrap(data.getParcelableExtra("newAssignment"));
            days.get(location).addAssignment(assignment);
            Log.i(TAG,"assignment added");
            // Update the adapter
            adapter.notifyDataSetChanged();
            rvDay.smoothScrollToPosition(0);
        }
        super.onActivityResult(requestCode,resultCode, data);
    }

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

        rvDay.setHasFixedSize(true);
        adapter.notifyDataSetChanged();
    }

}