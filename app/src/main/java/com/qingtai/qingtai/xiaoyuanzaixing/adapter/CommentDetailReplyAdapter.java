package com.qingtai.qingtai.xiaoyuanzaixing.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.CommentDetailReplyBean;
import com.qingtai.qingtai.xiaoyuanzaixing.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eafrey on 2017/1/5.
 */
public class CommentDetailReplyAdapter extends BaseAdapter{
    List<CommentDetailReplyBean> mDatas = new LinkedList<>();
    Context mContext;

    public CommentDetailReplyAdapter(Context context, List<CommentDetailReplyBean> data) {
        this.mDatas = data;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommentDetailHolder viewHolder;
        if(convertView == null) {
            viewHolder = new CommentDetailHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_comment_detail_reply, parent, false);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_comment_detail_item_reply_content);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_comment_detail_item_reply_time);
            viewHolder.tvUserName = (TextView) convertView.findViewById(R.id.tv_comment_detail_item_reply_user_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CommentDetailHolder) convertView.getTag();
        }

        viewHolder.tvContent.setText(mDatas.get(position).getContent());
        viewHolder.tvUserName.setText(mDatas.get(position).getUserName());
        viewHolder.tvTime.setText(mDatas.get(position).getReplyTime());

        return convertView;
    }
}

class CommentDetailHolder {
    TextView tvUserName;
    TextView tvTime;
    TextView tvContent;
}