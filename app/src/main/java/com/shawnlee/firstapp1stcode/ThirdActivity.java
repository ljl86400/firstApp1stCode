package com.shawnlee.firstapp1stcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThirdActivity extends BaseActivity {
    private String[] fruitList={"Apple","banana","orange","Apple","banana","orange",
            "Apple","banana","orange","Apple","banana","orange","Apple","banana","orange",
            "Apple","banana","orange","Apple","banana","orange","Apple","banana","orange",
            "Apple","banana","orange","Apple","banana","orange","Apple","banana","orange",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ArrayAdapter<String> fruitListAdapter=new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_list_item_1,fruitList);
        ListView fruitListView=(ListView) findViewById(R.id.list_view);
        fruitListView.setAdapter(fruitListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.third,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back_to_first_activity_from_third_activity:
                Intent backToFirstActivityFromThirdActivity=new Intent(ThirdActivity.this,FirstActivity.class);
                startActivity(backToFirstActivityFromThirdActivity);
                break;
            case R.id.finish_all_activities_from_third_activity:
                ActivityCollector.finishAll();
                break;
            default:
                break;
        }
        return true;
    }
}
