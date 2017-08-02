package com.example.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        replaceFrgment(new RightFragment());
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button:
                replaceFrgment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    /**
     * 该方法的作用是将右边的替换成AnotherRightFragment
     * 动态添加碎片共分五步：
     *      1. 创建待添加碎片
     *      2. 获取FragmentManager，在活动中可以直接调用getSupportFragmentManager()方法得到
     *      3. 开启一个事务，通过调用benginTransaction()方法开启。
     *      4. 向容器中添加或替换碎片，一般使用beginTransaction()方法实现，需要传入容器的id和待添加
     *      的碎片示例。
     *      5. 提交事务，通过commit()方法完成。
     * @param fragment：要替换的碎片
     */
    private void replaceFrgment(Fragment fragment) {
//        FragmentManager fragemtnManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragemtnManager.beginTransaction();
//        transaction.replace(R.id.right_layout, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }
}
