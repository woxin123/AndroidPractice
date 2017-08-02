package com.example.iuibestpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 孟晨 on 2017/7/26.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;


    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            leftMsg = (TextView) itemView.findViewById(R.id.left_msg);
            rightMsg = (TextView) itemView.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Msg> mMsgList) {
        this.mMsgList = mMsgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        // 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            // 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SEND) {
            // 如果是发送出去的，则显示右边的消息布局，将左边的消息布局隐藏
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
