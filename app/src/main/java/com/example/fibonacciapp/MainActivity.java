package com.example.fibonacciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFERENCE = "shared_preference";
    public static final String MY_HISTORY = "my_history";
    public static final String NUMBER_FOR_CALCULATION = "";
    public ArrayList<String> fibList;
    public int inputNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button okButton = findViewById(R.id.button_ok);
        final EditText fibonacciSeq = findViewById(R.id.tv_fibonacci_sequence);


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!fibonacciSeq.getText().toString().isEmpty()) {
                    int num =  Integer.parseInt( fibonacciSeq.getText().toString());
                    if (num == inputNum){
                        Intent intent = new Intent(context, activity_fibonacci_lists.class).putExtra("nums", Integer.parseInt( fibonacciSeq.getText().toString()) );
                        startActivity(intent);
                    } else {
                        saveData(num);
                        Intent intent = new Intent(context, activity_fibonacci_lists.class).putExtra("nums", Integer.parseInt( fibonacciSeq.getText().toString()) );
                        startActivity(intent);
                    }
                }
            }
        });

    }

    public void saveData(int num){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        ArrayList<Long> list;
        list = FibonacciNumbersCalculator.getNums(num);
        fibList = listToLongConverter.longToString(list);
        String json = gson.toJson(fibList);
        editor.putString(MY_HISTORY, json);
        editor.putInt(NUMBER_FOR_CALCULATION, num);
        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        inputNum = sharedPreferences.getInt(NUMBER_FOR_CALCULATION, 1);
    }

}
