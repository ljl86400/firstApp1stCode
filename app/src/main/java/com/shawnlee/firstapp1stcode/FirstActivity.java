package com.shawnlee.firstapp1stcode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class FirstActivity extends BaseActivity implements View.OnClickListener{
    public static final String TAG="FirstActivity";
    public ProgressBar sendBar;
    private EditText editText;
    private Button buttonSend;
    private Button buttonOpenBaidu;
    private Button buttonDial10086;
    private Button buttonOpenSecondActivity;
    private Button openThirdActivityButton;
    private Button openFourthActivityButton;
    private Button sendBroadCast1Button;
    private Button forceOfflineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.first_activity_layout);

        sendBar = findViewById(R.id.send_bar);
        editText= findViewById(R.id.edit_Text);

        // 实例一个button1的对象，并跟R.id.Button_1联系起来，在界面上对R.id.Button_1的操作就是对button1的操作
        buttonSend = findViewById(R.id.Button_send);
        buttonOpenBaidu = findViewById(R.id.Button_Open_Baidu);
        buttonDial10086 = findViewById(R.id.Button_Dial);
        buttonOpenSecondActivity = findViewById(R.id.button_open_second_activity);
        openThirdActivityButton = findViewById(R.id.button_open_third_activity);
        openFourthActivityButton = findViewById(R.id.button_open_fourth_activity);
        sendBroadCast1Button = findViewById(R.id.button_broad_cast_1);
        forceOfflineButton = findViewById(R.id.force_offline_button);

        buttonSend.setOnClickListener(this);
        buttonOpenBaidu.setOnClickListener(this);
        buttonDial10086.setOnClickListener(this);
        buttonOpenSecondActivity.setOnClickListener(this);
        openThirdActivityButton.setOnClickListener(this);
        openFourthActivityButton.setOnClickListener(this);
        sendBroadCast1Button.setOnClickListener(this);
        forceOfflineButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Button_send:
                // 获取edit_Text中输入的内容并转换成字符串，按键之后抛出提示
                String inputText=editText.getText().toString();
                int progress=sendBar.getProgress();
                progress=progress+10;
                if (progress==100|progress>100){
                    progress=0;
                }
                sendBar.setProgress(progress);
                Toast.makeText(FirstActivity.this,inputText,Toast.LENGTH_SHORT).show();
                break;
            case R.id.Button_Open_Baidu:
                Intent intentOpenBaidu=new Intent(Intent.ACTION_VIEW);
                intentOpenBaidu.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intentOpenBaidu);
                break;
            case R.id.Button_Dial:
                Intent intentDial=new Intent(Intent.ACTION_VIEW);
                intentDial.setData(Uri.parse("tel:10086"));
                startActivity(intentDial);
                break;
            case R.id.button_open_second_activity:
                // 将Intent启动改为隐式启动
                Intent intentOpenSecondActivity=new Intent("com.example.firstApp1stCode.SecondActivity.ACTION_START");
                String data="Hello,SecondActivity!";
                intentOpenSecondActivity.putExtra("messageFromFirstActivity",data);
                startActivity(intentOpenSecondActivity);
                break;
            case R.id.button_open_third_activity:
                Intent openThirdActivityIntent=new Intent(FirstActivity.this,ThirdActivity.class);
                startActivity(openThirdActivityIntent);
                break;
            case R.id.button_open_fourth_activity:
                Intent openFourthActivityIntent=new Intent(FirstActivity.this,FourthActivity.class);
                startActivity(openFourthActivityIntent);
                break;
            case R.id.button_broad_cast_1:
                Intent sendBroadcastIntent = new Intent("com.example.broadcasttest.MY_BROADCAST");
                sendBroadcast(sendBroadcastIntent);
                break;
            case R.id.force_offline_button:
                Intent forceOfflineIntent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(forceOfflineIntent);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "你按下的是添加键", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"你按下的是删除键",Toast.LENGTH_SHORT).show();
                break;
            // 在菜单键中添加一个退出选项，当点击退出时，退出当前活动回到上一个活动跟Back的功能一致
            case R.id.finish_item:
                ActivityCollector.finishAll();
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
