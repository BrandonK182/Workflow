package com.example.workflow;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Parcel
public class Day {
    static final String TAG = "dayObject";

    public String dayOfTheWeek;
    public String date;
    public ArrayList<Assignment> assignments;
    public int month;
    public int numDay;

    public Day(){
        dayOfTheWeek = "Leif Erikson Day";
        date = "10/09";
        month = 10;
        numDay = 9;
        assignments  = new ArrayList<>();
    }

    public Day(String dayOfTheWeek, String date){
        this.dayOfTheWeek = dayOfTheWeek;
        this.date = date;
        assignments  = new ArrayList<>();
    }

    public Day(String dayOfTheWeek, int month, int numDay){
        this.dayOfTheWeek = dayOfTheWeek;
        this.month = month;
        this.numDay = numDay;
        this.date = String.valueOf(month) + "/" + String.valueOf(numDay);
        assignments  = new ArrayList<>();
    }

    public void addAssignment(Assignment assignment)
    {
        Log.i(TAG,"ADDING ASSIGNMENT " + assignment.title);
        assignments.add(assignment);
    }

    public boolean equals(Day day)
    {
        return (this.month == day.month && this.numDay == day.numDay);
    }

    public void sortAssignments(){
        List<Assignment> newAssignments = null;
        int minValue;
        int minPosition ;

        for(int i = 0; i < assignments.size(); i++)
        {
            minValue = 25;
            minPosition = i;
            for(int j  = i; j < assignments.size(); j++)
            {
                if(assignments.get(j).hour < minValue)
                {
                    minValue = assignments.get(j).hour;
                    minPosition = j;
                }
            }
            newAssignments.add(assignments.get(minPosition));
        }
        assignments.clear();
        for (int i = 0; i<newAssignments.size(); i++)
        {
            assignments.add(newAssignments.get(i));
        }
    }
}
