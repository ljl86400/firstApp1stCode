package com.shawnlee.firstapp1stcode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Shawn.Lee on 2018/3/14.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());
        // 把当前的活动添加到集合类中
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 在生命周期的管理中，如果回调了当前的onDestroy方法，则将这个活动从集合类中删除
        ActivityCollector.removeActivity(this);
    }

}
