package com.example.ex2_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int RESULT_CODE = 201;
    Button button_finish_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        button_finish_result=findViewById(R.id.button_finish_result);
        button_finish_result.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //设置返回的数据
        Intent intent = new Intent();
        intent.putExtra("data", "HelloWorld");
        setResult(RESULT_CODE, intent);
        //关闭当前Activity
        finish();
    }
}