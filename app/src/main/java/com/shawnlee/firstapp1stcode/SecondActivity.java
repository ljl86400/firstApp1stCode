package com.shawnlee.firstapp1stcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonBackToFirstActivity=findViewById(R.id.back_FirstActivity);
        buttonBackToFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBackToFirstActivity=new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(intentBackToFirstActivity);
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
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
