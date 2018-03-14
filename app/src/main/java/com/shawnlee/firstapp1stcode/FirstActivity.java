package com.shawnlee.firstapp1stcode;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_layout);
        // 实例一个button1的对象，并跟R.id.Button_1联系起来，在界面上对R.id.Button_1的操作
        // 就是对button1的操作
        Button buttonOpenBaidu=(Button) findViewById(R.id.Button_Open_Baidu);
        // setOnClickListener后面的括号中是一段可执行代码，表示对点击的响应动作
        buttonOpenBaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOpenBaidu=new Intent(Intent.ACTION_VIEW);
                intentOpenBaidu.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intentOpenBaidu);
            }
        });

        Button buttonDial=(Button) findViewById(R.id.Button_Dial);
        // setOnClickListener后面的括号中是一段可执行代码，表示对点击的响应动作
        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDial=new Intent(Intent.ACTION_VIEW);
                intentDial.setData(Uri.parse("tel:10086"));
                startActivity(intentDial);
            }
        });

        Button buttonOpenSecondActivity=(Button)findViewById(R.id.Button_Open_Second_Activity);
        buttonOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 将Intent启动改为隐式启动
                Intent openSecondActivity=new Intent("com.example.firstApp1stCode.SecondActivity.ACTION_START");
                startActivity(openSecondActivity);
            }
        });


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
            // 在菜单键中添加一个退出选项，当点击退出时，退出当前活动
            case R.id.finish_item:
                finish();
            default:
                break;
        }
       return true;
    }
}
