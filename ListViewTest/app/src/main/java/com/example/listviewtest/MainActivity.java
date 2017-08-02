package com.example.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private String[] data= {"Apple", "Banana", "Orange", "Watermelon",
//        "pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
//            "Apple", "Banana", "Orange", "Watermelon", "pear", "Grape",
//            "Pineapple", "Strawberry", "Cherry", "Mango"};

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();           // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        /**
         * 使用setOnItemClickListener()方法为ListView注册了一个检同期，
         * 当用户点击ListView中的任何一个子项时，就会毁掉onItemClick()方法。
         * 在这个方法中可以通过position参数来判断出用用户点击的是哪一个子项
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long ld) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initFruits () {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple);
            Fruit apple1 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple1);
            Fruit apple2 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple2);
            Fruit apple3 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple3);
            Fruit apple4 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple4);
            Fruit apple5 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple5);
            Fruit apple6 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple6);
            Fruit apple7 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple7);
            Fruit apple8 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple8);
            Fruit apple9 = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple9);
        }

    }
}
