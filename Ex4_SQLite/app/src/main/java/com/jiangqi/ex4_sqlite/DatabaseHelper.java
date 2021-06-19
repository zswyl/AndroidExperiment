package com.jiangqi.ex4_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final int VERSION=1;
    // DatabaseHelper作为一个访问sQLite的助手类,提供两个方面的功能
    public DatabaseHelper(Context context, String name, CursorFactory factory,
                          int version)
    {
        //必须通过super调用父类当中的构造函数
        super(context, name, factory, version);
    }
    public DatabaseHelper (Context context,String name,int version){
        this (context, name, null, version) ;
    }
    public DatabaseHelper(Context context, String name)
    {
        this(context, name,VERSION);
    }
    //该函数是在第一次创建数据库的时候执行
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        System.out.println ("create a Database");
        // execsQL.函数用于执行sQz语句
        db.execSQL ( "create table user (id int,name varchar (20),age int ) ");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        System.out.println ( "update a Database") ;

    }
}