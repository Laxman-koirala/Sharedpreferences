package com.example.fibonacciapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.FibonacciViewHolder> {

    private ArrayList<Long> list;

    public MyAdapter(ArrayList<Long> fibonacciList) {
        this.list = fibonacciList;
    }


    @NonNull
    @Override
    public MyAdapter.FibonacciViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View lineView = inflater.inflate(R.layout.recycler_row, parent, false);
        return new FibonacciViewHolder(lineView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.FibonacciViewHolder holder, int position) {
        holder.lineText.setText("" + (position + 1) + ". " + list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class FibonacciViewHolder extends RecyclerView.ViewHolder {
        TextView lineText;

        public FibonacciViewHolder(@NonNull View itemView) {
            super(itemView);
            this.lineText = itemView.findViewById(R.id.tv_line_recycler);
        }
    }
}
