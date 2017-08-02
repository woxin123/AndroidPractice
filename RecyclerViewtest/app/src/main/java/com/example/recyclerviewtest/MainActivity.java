package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();   // 初始化水果数据
        /**
         * LinearLayoutManger用于指定RecyclerView的布局方式
         * LinearLayoutManager是线性布局的意思，可以实现和ListView类似的效果
         */
        RecyclerView recycleView = (RecyclerView) findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManger = new LinearLayoutManager(this);
        /**
         * 调用LinearLayoutManager的setOrientation()方法来设置布局的排雷方式
         */
//        layoutManger.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recycleView.setLayoutManager(layoutManger);
        StaggeredGridLayoutManager layoutManner = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManner);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recycleView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 20; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana);
            fruitList.add(banana);
        }
    }

    /**
     * 瀑布流的效果需要各个子项的高度不一致
     * @param name:传入一个水果的名字
     * @return：将其复制1~20之间任意一个数字的倍数，然后返回
     */
    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length  = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
