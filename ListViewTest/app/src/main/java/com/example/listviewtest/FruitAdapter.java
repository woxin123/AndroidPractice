package com.example.listviewtest;

import android.content.Context;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by 孟晨 on 2017/7/24.
 */

/**
 * Android 中提供了很多适配器的实现类
 * ArrayAdapter是其中比较好用的
 * ArrayAdapter的构造器有多个，应该根据实际情况选择
 *
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    /**
     *
     * @param context:上下文
     * @param textViewResourceId：ListView的id
     * @param objects：要适配的数据
     */
    public FruitAdapter(@NonNull Context context, @LayoutRes int textViewResourceId,
                        @NonNull List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    /**
     *
     * @param position
     * @param convertView：用于将之前加载好的布局进行缓存
     * @param parent
     * @return
     *
     * getView()这个方法在每个子项被滚动到屏幕内的时候会被调用
     * 首先通过getItem()方法得到当前的Fruit实例，
     * 然后使用LayoutInflater来为这个子项加载我们传入的布局
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            /**
             * 从上下文中
             * 第三个参数一旦指定为false，表示只让我们在父布局中声明的layout生效，
             * 但不为这个View添加父布局，
             * 因为这个View添加父布局之后就不能添加到ListView中了。
             */
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);    // 将viewHolder储存在View中
        }
        else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        /**
         * setImageResource
         * Sets a drawable as the content of this ImageView
         * 设置一个图片作为内容
         */
        viewHolder.fruitImage.setImageResource(fruit.getImagedId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder {
        ImageView fruitImage;

        TextView fruitName;
    }
}
