package com.android.wrf_mac.listviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    //定义一个数组来存储ListView中的内容
    private static final String[] str = new String[]{"first", "second", "third", "fourth", "fifth"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = (ListView) findViewById(R.id.list_view);
        //声明适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, str);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //绑定适配器
        lv.setAdapter(adapter);
        //ListView的Item的点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "你点击的是第" + position + "行", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
