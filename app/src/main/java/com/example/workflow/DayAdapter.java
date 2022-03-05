package com.example.workflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.ViewHolder> {

    public static final String TAG = "DAY ADAPTER";

    Context context;
    List<Day> days;

    public DayAdapter(Context context, List<Day> days)
    {
        this.context = context;
        this.days = days;
    }

    // For Each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.day_layout, parent, false);
        return new ViewHolder(view);
    }

    //bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data at position
        Day day = days.get(position);
        //Bind the tweet with view holder
        holder.bind(day);
    }


    @Override
    public int getItemCount() {
        return days.size();
    }

    //removes all elements of the recycler
    public void clear(){
        days.clear();
        notifyDataSetChanged();
    }

    //adds a list of items to the the data
    public void addAll(List<Day> dayList){
        days.addAll(dayList);
        notifyDataSetChanged();
    }

    //define the view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout container;
        TextView tvDayOfWeek;
        TextView tvDate;
        RecyclerView rvAssignment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDayOfWeek = itemView.findViewById(R.id.tvDayOfWeek);
            tvDate = itemView.findViewById(R.id.tvDate);
            rvAssignment = itemView.findViewById(R.id.rvAssignment);
            container = itemView.findViewById(R.id.dayContainer);
        }

        public void bind(Day day) {
            tvDayOfWeek.setText(day.dayOfTheWeek);
            tvDate.setText(day.date);
        }
    }
}
