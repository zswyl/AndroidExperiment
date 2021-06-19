package com.jiangqi.radiocase;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class ActivityConllector {
    private static final String TAG = "ActivityConllector";
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        Log.d(TAG,"添加当前活动");
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        Log.d(TAG,"移除当前活动");
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities){
            if(!activity.isFinishing()){
                Log.d(TAG,"关闭所有活动");
                activity.finish();
            }
        }
    }
}
