package com.example.fibonacciapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class activity_fibonacci_lists extends AppCompatActivity {
    RecyclerView recyclerView;
    public ArrayList<Long> fibList;
    public  ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci_lists);
        recyclerView = findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        int num = getIntent().getIntExtra("nums", 1);


        //int iterations = 100;
        ArrayList<Long> fibList = FibonacciNumbersCalculator.getNums(num);
        MyAdapter adapter = new MyAdapter(fibList);
        recyclerView.setAdapter(adapter);
    }

        //retrieve last position on start
        public void loadData () {
            SharedPreferences sharedPreferences = getSharedPreferences("sharedRef", MODE_PRIVATE);
            Gson gson = new Gson();
            String json = sharedPreferences.getString("history", null);
            Type type = new TypeToken<ArrayList<String>>() {
            }.getType();
            if (gson.fromJson(json, type) == null) {

                fibList = new ArrayList<>();
            } else {
                list = gson.fromJson(json, type);
                fibList = listToLongConverter.stringsToLongs(list);
            }
        }


}


