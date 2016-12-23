package com.qingtai.qingtai.xiaoyuanzaixing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.SharePageReplyMessage;
import com.qingtai.qingtai.xiaoyuanzaixing.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eafrey on 2016/12/23.
 */
public class SharePageReplyAdapter extends BaseAdapter {
    List<SharePageReplyMessage> mDatas = new LinkedList<>();
    Context mContext;

    public  SharePageReplyAdapter(Context context, List<SharePageReplyMessage> msg) {
        this.mContext = context;
        this.mDatas = msg;
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
        ReplyViewHolder viewHoleder = null;
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_reply_share_page, parent, false);
            viewHoleder = new ReplyViewHolder();
            viewHoleder.tvComment = (TextView) convertView.findViewById(R.id.tv_item_reply_comment);
            viewHoleder.tvUserName = (TextView) convertView.findViewById(R.id.tv_item_reply_user_name);
            viewHoleder.tvFavour = (TextView) convertView.findViewById(R.id.tv_item_reply_fovour);
            viewHoleder.tvReplyTime = (TextView) convertView.findViewById(R.id.tv_item_reply_time);
            viewHoleder.tvReplyContent = (TextView) convertView.findViewById(R.id.tv_item_reply_content);
            convertView.setTag(viewHoleder);
        } else {
            viewHoleder = (ReplyViewHolder) convertView.getTag();
        }

        viewHoleder.tvReplyContent.setText(mDatas.get(position).getReply());
        viewHoleder.tvComment.setText(mDatas.get(position).getCommentCount());
        viewHoleder.tvFavour.setText(mDatas.get(position).getFavourCount());
        viewHoleder.tvUserName.setText(mDatas.get(position).getUserName());
        viewHoleder.tvReplyTime.setText(mDatas.get(position).getReplyTime());

        return convertView;
    }
}

class ReplyViewHolder {
    TextView tvUserName;
    TextView tvReplyContent;
    TextView tvReplyTime;
    TextView tvFavour;
    TextView tvComment;
}