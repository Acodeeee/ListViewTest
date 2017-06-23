package com.android.wrf_mac.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wrf_mac on 2017/6/23.
 */

public class FruitAdapter extends ArrayAdapter {

    //保存资源文件的id
    private int resourceId;


    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    /**
     * TODO:每个子项滚动到屏幕内会调用此方法
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //获取Fruit实例
        Fruit fruit = (Fruit) getItem(position);
        //添加子项到父布局
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        //给子项添加图片和赋值
        ImageView imageView = (ImageView) view.findViewById(R.id.fruit_image);
        TextView textView = (TextView) view.findViewById(R.id.fruit_text);
        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());

        return view;
    }
}
