package com.jiangqi.ex4_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText id;
    private EditText name;
    private EditText age;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        button=findViewById(R.id.button1);
        button.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
                DatabaseHelper dbHelper = new DatabaseHelper(InsertActivity.this, "test_db");
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("id", String.valueOf(id.getText()));
                values.put("name",name.getText().toString());
                values.put("age", String.valueOf(age.getText()));
                db.insert("user", null, values);
                Toast.makeText(this,"添加数据成功",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(InsertActivity.this,MainActivity.class);
                startActivity(intent);

    }

}