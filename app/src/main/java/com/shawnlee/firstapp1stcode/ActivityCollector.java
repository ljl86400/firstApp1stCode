package com.shawnlee.firstapp1stcode;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个集合类，用于完成任何Activity中一键退出程序
 * Created by Shawn.Lee on 2018/3/14.
 */

public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
