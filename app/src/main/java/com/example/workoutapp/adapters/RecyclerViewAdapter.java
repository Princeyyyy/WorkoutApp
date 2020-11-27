package com.example.workoutapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutapp.R;
import com.example.workoutapp.models.Workout;
import com.example.workoutapp.results.Result;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerHolder> {
    private Context mContext;
    private ArrayList<Result> mResults;

    public RecyclerViewAdapter(Context context, ArrayList<Result> results) {
        mContext = context;
        mResults = results;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_row, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row, parent, false);
        RecyclerHolder viewHolder = new RecyclerHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerHolder holder, int position) {
        Result result = mResults.get(position);

        String name = result.getName();
        String description = result.getDescription();

        holder.mTextViewName.setText(name);
        holder.mTextViewDescription.setText(description);

    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewName;
        public TextView mTextViewDescription;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.text_view_name);
            mTextViewDescription = itemView.findViewById(R.id.text_view_description);
        }
    }

}
