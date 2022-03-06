package com.example.workflow;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Assignment")
public class Post extends ParseObject {

    public static final String KEY_DATE = "date";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CLASS = "class";

    public String getDate()
    {
        return getString(KEY_DATE);
    }

    public void setDate(String date)
    {
        put(KEY_DATE, date);
    }

    public String getTitle()
    {
        return getString(KEY_TITLE);
    }

    public void setTitle(String title)
    {
        put(KEY_TITLE, title);
    }

    public String getClassName(){ return getString(KEY_CLASS); }

    public void setClassName(String className) {
        put(KEY_CLASS, className);
    }
}
