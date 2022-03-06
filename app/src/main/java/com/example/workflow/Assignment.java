package com.example.workflow;

import org.parceler.Parcel;

@Parcel
public class Assignment {
    public String className;
    public String title;
    public String dueTime;
    public int hour;
    public int minute;

    public Assignment(){
        className = "Math";
        title = "Testeritto";
        dueTime = "4:30";
        hour = 4;
        minute = 30;
    }

    public Assignment(String className, String title, String dueTime){
        this.className = className;
        this.title = title;
        this.dueTime = dueTime;
        this.hour = 0;
        this.minute = 0;
    }

    public Assignment(String className, String title, int hour, int minute){
        this.className = className;
        this.title = title;
        this.hour = hour;
        this.minute = minute;
        this.dueTime = String.valueOf(hour) + ":" + String.valueOf(minute);
    }
}
