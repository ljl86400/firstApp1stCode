package com.shawnlee.firstapp1stcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 功能：
 * 按回到主界面按钮，返回FirstActivity；
 * 在menu中添加退出程序item，点击后退出程序
 * 添加提示对话按钮，点击后跳出一个对话提示
 * 添加网络状态变化监控机制
 */

public class SecondActivity extends BaseActivity {
    public static final String TAG="SecondActivity";
    private IntentFilter netSituationIntentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_second);
        Intent intentFromFirstActivity=getIntent();
        String messageFromFirstActivity=intentFromFirstActivity.getStringExtra("messageFromFirstActivity");
        Log.d("SecondActivity",messageFromFirstActivity);

        // 注册一个广播接收策略，接收系统的网络状态变化信息
        netSituationIntentFilter=new IntentFilter();
        netSituationIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,netSituationIntentFilter);

        // 按键后返回FirstActivity
        Button buttonBackToFirstActivity=findViewById(R.id.back_FirstActivity);
        buttonBackToFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBackToFirstActivity=new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(intentBackToFirstActivity);
            }
        });

        // 按键后跳出一个对话提示
        Button dialogButton=(Button)findViewById(R.id.dialog_button);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle("提示对话");
                dialog.setMessage("选择OK确认，选择Cancel取消");
                // 点击对话之外的区域是否响应，true 为响应，false 为不响应
                dialog.setCancelable(false);
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    // 此处并未添加执行语句
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    // 此处并未添加执行语句
                    }
                });
                dialog.show();
            }
        });
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectionManager = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "发现可用网络", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "没有可用网络", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 在SecondActivity中创建一个菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second,menu);
        return true;
    }


    /**
     * 当点击menu中的退出程序item时候，执行退出程序
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.second_finish_item:
                ActivityCollector.finishAll();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        Log.d(TAG, "onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
