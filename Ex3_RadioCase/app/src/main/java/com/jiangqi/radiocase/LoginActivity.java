package com.jiangqi.radiocase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG ="LoginActivity" ;
    private EditText userName;
    private EditText passWord;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText)findViewById(R.id.account);
        passWord = (EditText)findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Log.d(TAG,"登录"+getClass().getSimpleName());
                String username = userName.getText().toString();
                String password = passWord.getText().toString();
                if(username.equals("admin") && password.equals("123")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "用户名或者密码错误!", Toast.LENGTH_SHORT).show();
                }

        }

    }
}
