package com.example.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 孟晨 on 2017/7/27.
 */

public class LeftFragment extends Fragment {
    /**
     * 这个方法通过刚才的LayoutInflate()的inflate()方法将刚才定义的left_fragment布局加载进来
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment, container, false);
        return view;
    }
}
