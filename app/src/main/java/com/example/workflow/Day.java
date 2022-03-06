package com.example.workflow;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Day {
    public String dayOfTheWeek;
    public String date;
    public List<Assignment> assignments;

    public Day(){
        dayOfTheWeek = "Leif Erikson Day";
        date = "10/9";
    }

    public Day(String dayOfTheWeek, String date){
        this.dayOfTheWeek = dayOfTheWeek;
        this.date = date;
    }

    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
    }
}
