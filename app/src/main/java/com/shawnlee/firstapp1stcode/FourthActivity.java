package com.shawnlee.firstapp1stcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends BaseActivity {
    private List<Fruit> fruitList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        initFruit();
        FruitAdapter fruitImageAdapter=new FruitAdapter(FourthActivity.this,
                R.layout.fruit_list_view_image_item,fruitList);
        ListView fruitImageListView=(ListView)findViewById(R.id.list_view_of_fourth_activity);
        fruitImageListView.setAdapter(fruitImageAdapter);
    }

    private void initFruit(){
        for (int i = 0;i < 20;i ++){
            Fruit apple=new Fruit("apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana=new Fruit("banana",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange=new Fruit("orange",R.drawable.orange_pic);
            fruitList.add(orange);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fourth_activity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back_to_first_activity_from_fourth_activity_item:
                Intent backToFirstActivityFromFourthActivityIntent=new Intent(FourthActivity.this,FirstActivity.class);
                startActivity(backToFirstActivityFromFourthActivityIntent);
                break;
            case R.id.finish_all_activities_from_fourth_activity_item:
                ActivityCollector.finishAll();
                break;
            default:
                break;
        }
        return true;
    }
}
