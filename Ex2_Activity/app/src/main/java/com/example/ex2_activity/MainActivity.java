package com.example.ex2_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 101;
    Button button_imp;
    Button button_display;
    Button button_deliver;
    TextView text_resulet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_imp=findViewById(R.id.button_imp);
        button_display=findViewById(R.id.button_display);
        button_deliver=findViewById(R.id.button_deliver);
        text_resulet=findViewById(R.id.text_resulet);
        button_imp.setOnClickListener(this);
        button_display.setOnClickListener(this);
        button_deliver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_imp:
                Intent intent = new Intent("com.example.ex2_activity.JHY_ACTION");
                intent.addCategory("com.example.ex2_activity.JHY_CATEGORY");
                startActivity(intent);
                break;
            case R.id.button_display:
                Intent intent1 = new Intent(MainActivity.this, ThirdActivity.class);
                intent1.putExtra("msg", "HelloWorld");
                startActivity(intent1);
                break;
            case R.id.button_deliver:
                Intent intent2 = new Intent(MainActivity.this, FourthActivity.class);
                startActivityForResult(intent2, REQUEST_CODE);
                text_resulet.setText("");
                break;
        }
    }
    // 处理回调数据
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断请求码
        if (requestCode == REQUEST_CODE) {
            //判断结果码
            if (resultCode == FourthActivity.RESULT_CODE) {
                String result = data.getStringExtra("data");

                text_resulet.setText("结果显示为："+result);
            }else{
                text_resulet.setText("没有回传数据");
            }
        }
    }

}