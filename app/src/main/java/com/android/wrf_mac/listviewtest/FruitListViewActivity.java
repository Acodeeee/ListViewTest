package com.android.wrf_mac.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FruitListViewActivity extends AppCompatActivity {

    List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list_view);
        ListView lv = (ListView) findViewById(R.id.list_view_fruit) ;
        initFruits();
        //创建适配器
        FruitAdapter fruitAdapter = new FruitAdapter(FruitListViewActivity.this,
                R.layout.fruit_item, fruits);

        //绑定适配器
        lv.setAdapter(fruitAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FruitListViewActivity.this, "你点击了第" + position + "行", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 初始化fruits
     */
    private void initFruits(){
        for (int i=0; i<20; i++){
            Fruit fruit = new Fruit();
            fruit.setImageId(R.mipmap.ic_launcher);
            fruit.setName(i + "");
            fruits.add(fruit);
        }
    }
}
