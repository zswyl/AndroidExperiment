package com.example.ex2_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class ReceiveActivity extends AppCompatActivity {
    private TextView action_txt;
    private TextView category_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        action_txt=findViewById(R.id.action_txt);
        category_txt=findViewById(R.id.category_txt);
        Intent intent=getIntent();
        action_txt.setText(intent.getAction());
        Set<String> categories=intent.getCategories();
        for (String s:categories){
            category_txt.setText(s);
        }

    }
}