package com.shawnlee.firstapp1stcode;

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
        Button button1=(Button) findViewById(R.id.Button_1);
        // setOnClickListener后面的括号中是一段可执行代码，表示对点击的响应动作
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this,"你刚点击了上按键",Toast.LENGTH_SHORT)
                        .show();
            }
        });

        Button button2=(Button) findViewById(R.id.Button_2);
        // setOnClickListener后面的括号中是一段可执行代码，表示对点击的响应动作
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this,"你刚点击了下按键",Toast.LENGTH_SHORT)
                        .show();
            }
        });

        Button button3=(Button)findViewById(R.id.Button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "你刚按下了练习按键", Toast.LENGTH_SHORT)
                        .show();
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
            default:
                break;
        }
       return true;
    }
}
