package com.example.workflow;

import java.util.List;

public class Day {
    public String dayOfTheWeek;
    public String date;
    public List<Assignment> dueAssignments;

    public Day(){
        dayOfTheWeek = "Leif Erikson Day";
        date = "6/9/4200";
        //dueAssignments.add(new Assignment());
    }
}
