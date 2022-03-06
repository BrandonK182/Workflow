package com.example.workflow;

import java.util.List;

public class Day {
    public String dayOfTheWeek;
    public String date;

    public Day(){
        dayOfTheWeek = "Leif Erikson Day";
        date = "6/9/4200";
    }

    public Day(String dayOfTheWeek, String date){
        this.dayOfTheWeek = dayOfTheWeek;
        this.date = date;
    }
}
