package com.example.iuibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();      // 初始化消息数据
        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    Log.e("MainActivity", "一");
                    adapter.notifyItemInserted(msgList.size() - 1);
                    Log.e("MainActivity", "一");
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    Log.e("MainActivity", "一");
                    inputText.setText(""); // 清空输入框的内容
                    Log.e("MainActivity", "一");
                }
            }
        });
    }

    private void initMsg() {
        Msg msg1 = new Msg("你好", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("你好，最近怎么样？", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("我是。。。，很高兴与你讲话", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
