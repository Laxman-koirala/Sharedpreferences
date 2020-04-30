package com.example.fibonacciapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        final EditText fibonacciSeq = findViewById(R.id.tv_fibonacci_sequence);
        Button okButton = findViewById(R.id.button_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!fibonacciSeq.getText().toString().isEmpty()) {
                    Intent intent = new Intent(context,activity_fibonacci_lists.class).putExtra("nums", Integer.parseInt( fibonacciSeq.getText().toString()) );
                    startActivity(intent);
                }
            }
        });

    }
}
