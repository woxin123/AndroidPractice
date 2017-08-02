package com.example.fragmentbestpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 孟晨 on 2017/7/28.
 */

public class NewsContentFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    /**
     * 该方法的主要作用是将新闻的标题和内容显示在界面上
     * @param newsTitle:标题内容
     * @param newsContent：新闻内容
     */
    public void refresh(String newsTitle, String newsContent) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTileText = (TextView) view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView) view.findViewById(R.id.news_content);
        newsTileText.setText(newsTitle);        // 刷新新闻标题
        newsContentText.setText(newsContent);   // 刷新新闻内容
    }
}
