package com.jiangqi.ex4_sqlite;



import android.app.AlertDialog;
import android.app.Dialog;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;

import android.view.View;

import android.widget.Button;

import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = findViewById(R.id.create);
        Button addData = findViewById(R.id.add);
        Button updateData = findViewById(R.id.update);
        Button deleteData = findViewById(R.id.delete);
        Button queryData = findViewById(R.id.query);
        setTitle("软件1802-朱松望-1811030202");
        createDatabase.setOnClickListener(listenner);
        addData.setOnClickListener(listenner);
        updateData.setOnClickListener(listenner);
        deleteData.setOnClickListener(listenner);
        queryData.setOnClickListener(listenner);

    }

    private View.OnClickListener listenner = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this, "test_db");

            switch (button.getId()) {
                //创建数据库
                case R.id.create:
                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    Toast.makeText(MainActivity.this, "创建数据库成功", 1).show();
                    break;
                // 插入数据
                case R.id.add:
                    Intent intent=new Intent(MainActivity.this,InsertActivity.class);
                    startActivity(intent);
                    break;
                // 数据库更新数据
                case R.id.update:
                    Intent intent1=new Intent(MainActivity.this,updateActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.delete:
                    SQLiteDatabase db4 = dbHelper.getWritableDatabase();
                    db4.delete("user", "id=?", new String[]{"1"});
                    Toast.makeText(MainActivity.this, "删除成功", 1).show();
                    break;
                case R.id.query:
                    SQLiteDatabase db5 = dbHelper.getWritableDatabase();
                    Cursor cursor = db5.rawQuery("select * from user where id=?",new String[]{"1"});
                    while (cursor.moveToNext()){
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String age=cursor.getString(cursor.getColumnIndex("age"));
                        Dialog dialog=new AlertDialog.Builder(MainActivity.this)
                                .setTitle("查询的数据").setMessage("姓名："+name+"年龄："+age)
                                .setPositiveButton("确定",null).show();
                    }
                    break;
            }
        }
    };


}