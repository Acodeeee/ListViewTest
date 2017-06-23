package com.android.wrf_mac.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        View view;
        ViewHolder viewHolder = new ViewHolder();
        //添加子项到父布局
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.textView = (TextView) view.findViewById(R.id.fruit_text);
            viewHolder.button = (Button) view.findViewById(R.id.fruit_button);
            view.setTag(viewHolder);
        }else {
            view = convertView;
        }

        //给子项添加图片和赋值
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "I`m Button!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    /**
     * TODO:通过一个内部类，缓存控件实例，避免频繁的findViewById消耗时间
     */
    private class ViewHolder{
        ImageView imageView;
        TextView textView;
        Button button;
    }
}
