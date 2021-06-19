package com.example.ex2_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView msg_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        msg_txt=findViewById(R.id.msg_txt);
        Intent intent = getIntent();
        String msg= intent.getStringExtra("msg");
        msg_txt.setText(msg);
    }
}