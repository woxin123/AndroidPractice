package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "草草哦啊从哦啊草草草草草草草草草草丛啊次哦啊从安次哦啊", Toast.LENGTH_SHORT).show();
    }
}
