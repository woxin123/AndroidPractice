package com.example.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 孟晨 on 2017/7/26.
 */


/**
 * 此类是为RecyclerView准备适配器用的
 * 首先定义了一个内部类ViewHolder，ViewHolder要继承自RecyclerView.ViewHolder
 * 然后ViewHolder的构造器中传入一个View参数，
 * 这个参数通常就是RecycleView的子项的最外层布局
 * 然后就可以通过findViewId()方法来获取布局中的ImageView和TextView的实例了。
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> myFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        // fruitView用于保存子项最外层布局的实例
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    /**
     * 该构造器的作用是将List数据传送进来
     * @param myFruitList:要传送的数据
     */
    public FruitAdapter(List<Fruit> myFruitList) {
        this.myFruitList = myFruitList;
    }

    /**
     * 该类是继承RecyclerView.Adapter
     * 那么就必须重写onCreateViewHolder()、onBindViewHolder()、getItemCount()这三个方法
     * @param parent
     * @param viewType
     * @return
     * onCreateViewHolder()使用来创建ViewHolder实例的，
     * 这个方法中将fruit_item布局加载进来，然后创建一个ViewHolder实例
     * 并把加载出来的布局出入到构造函数中，最后将ViewHolder返回
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 得到所点击的Fruit的position
                int position = holder.getAdapterPosition();
                Fruit fruit = myFruitList.get(position);
                Toast.makeText(view.getContext(), "You Click View" + fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = myFruitList.get(position);
                Toast.makeText(view.getContext(), "You clicked image" + fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    /**
     *
     * @param holder
     * @param position
     * 该方法用于读RecycleView子项数据进行赋值
     * 会在每个子项被滚到屏幕内的时候执行
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = myFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImagedId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return myFruitList.size();
    }
}
