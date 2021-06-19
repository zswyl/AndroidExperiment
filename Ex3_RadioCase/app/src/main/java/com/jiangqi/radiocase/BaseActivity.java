package com.jiangqi.radiocase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity  extends AppCompatActivity{
    private static final String TAG = "BaseActivity";
    private ForceOffLineReceiver forceOffLineReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(TAG,"活动父类初始化"+getClass().getSimpleName());
        ActivityConllector.addActivity(this);
        //在这里动态注册广播接收器
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"注册广播接收器"+getClass().getSimpleName());
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.jiangqi.action.FORCE_OFFLINE");
        forceOffLineReceiver=new ForceOffLineReceiver();
        registerReceiver(forceOffLineReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"取消广播接收器注册"+getClass().getSimpleName());
        if (forceOffLineReceiver!=null){
            unregisterReceiver(forceOffLineReceiver);
            forceOffLineReceiver=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"关闭当前活动"+getClass().getSimpleName());
        ActivityConllector.removeActivity(this);
//在这里注销广播接收器
    }
    class ForceOffLineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("warning");
            builder.setMessage("您被强制下线, 请您重新登录!");
            builder.setCancelable(false); // 将对话框设置为不可取消
            // 给按钮添加注册监听
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 点击按钮所调用的方法
                    Log.d(TAG,"广播接收器收到广播，销毁所有的活动,并跳到活动界面"+getClass().getSimpleName());
                    ActivityConllector.finishAll();//销毁所有的活动
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }
}