package com.example.workflow;

import org.parceler.Parcel;

@Parcel
public class Assignment {
    public String className;
    public String title;
    public String dueTime;

    public Assignment(){
        className = "Math";
        title = "Testeritto";
        dueTime = "69:69";
    }

    public Assignment(String className, String title, String dueTime){
        this.className = className;
        this.title = title;
        this.dueTime = dueTime;
    }
}
