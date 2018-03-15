package com.shawnlee.firstapp1stcode;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
    public static final String TAG="SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_second);
        Intent intentFromFirstActivity=getIntent();
        String messageFromFirstActivity=intentFromFirstActivity.getStringExtra("messageFromFirstActivity");
        Log.d("SecondActivity",messageFromFirstActivity);

        Button buttonBackToFirstActivity=findViewById(R.id.back_FirstActivity);
        buttonBackToFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBackToFirstActivity=new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(intentBackToFirstActivity);
            }
        });

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

    // finish 是退出当前界面，回到前一个界面
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
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
