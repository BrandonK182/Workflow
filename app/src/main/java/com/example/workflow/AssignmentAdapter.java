package com.example.workflow;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder> {

    public static final String TAG = "ASSIGNMENT ADAPTER";

    Context context;
    List<Assignment> assignments;

    public AssignmentAdapter(Context context, List<Assignment> assignments)
    {
        this.context = context;
        this.assignments = assignments;
    }

    // For Each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.assignment_layout, parent, false);
        return new ViewHolder(view);
    }

    //bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data at position
        Assignment assignment = assignments.get(position);
        holder.bind(assignment);
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    //removes all elements of the recycler
    public void clear(){
        assignments.clear();
        notifyDataSetChanged();
    }

    //adds a list of items to the the data
    public void addAll(List<Assignment> assignmentList){
        assignments.addAll(assignmentList);
        notifyDataSetChanged();
    }

    //define the view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvClass;
        TextView tvTitle;
        TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClass = itemView.findViewById(R.id.tvClass);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvTime = itemView.findViewById(R.id.tvTime);
        }

        public void bind(Assignment assignment) {
            tvClass.setText(assignment.className);
            tvTime.setText(assignment.dueTime);
            tvTitle.setText(assignment.title);
        }
    }
}
