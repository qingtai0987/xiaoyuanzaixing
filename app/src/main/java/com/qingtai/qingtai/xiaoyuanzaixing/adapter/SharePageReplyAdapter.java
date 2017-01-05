package com.qingtai.qingtai.xiaoyuanzaixing.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.SharePageReplyBean;
import com.qingtai.qingtai.xiaoyuanzaixing.R;
import com.qingtai.qingtai.xiaoyuanzaixing.activity.CommentDetail;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eafrey on 2016/12/23.
 */
public class SharePageReplyAdapter extends BaseAdapter implements View.OnClickListener {
    List<SharePageReplyBean> mDatas = new LinkedList<>();
    Context mContext;

    public  SharePageReplyAdapter(Context context, List<SharePageReplyBean> msg) {
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
            viewHoleder.tvCommentCount = (TextView) convertView.findViewById(R.id.tv_share_page_item_reply_comment);
            viewHoleder.tvUserName = (TextView) convertView.findViewById(R.id.tv_share_page_item_reply_user_name);
            viewHoleder.tvFavourCount = (TextView) convertView.findViewById(R.id.tv_share_page_item_reply_favour);
            viewHoleder.tvReplyTime = (TextView) convertView.findViewById(R.id.tv_share_page_item_reply_time);
            viewHoleder.tvReplyContent = (TextView) convertView.findViewById(R.id.tv_share_page_item_reply_content);
            viewHoleder.llComment = ((LinearLayout) convertView.findViewById(R.id.ll_share_page_item_reply_comment));
            viewHoleder.llFavour = ((LinearLayout) convertView.findViewById(R.id.ll_share_page_item_reply_favour));
            convertView.setTag(viewHoleder);
        } else {
            viewHoleder = (ReplyViewHolder) convertView.getTag();
        }

        viewHoleder.tvReplyContent.setText(mDatas.get(position).getReply());
        viewHoleder.tvCommentCount.setText(mDatas.get(position).getCommentCount());
        viewHoleder.tvFavourCount.setText(mDatas.get(position).getFavourCount());
        viewHoleder.tvUserName.setText(mDatas.get(position).getUserName());
        viewHoleder.tvReplyTime.setText(mDatas.get(position).getReplyTime());

        viewHoleder.llComment.setOnClickListener(this);
        viewHoleder.llFavour.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_share_page_item_reply_favour:
                break;
            case R.id.ll_share_page_item_reply_comment:
                Intent intent = new Intent(v.getContext(), CommentDetail.class);
                v.getContext().startActivity(intent);
                break;
            default:
                break;
        }
    }
}

class ReplyViewHolder {
    TextView tvUserName;
    TextView tvReplyContent;
    TextView tvReplyTime;
    TextView tvFavourCount;
    TextView tvCommentCount;
    LinearLayout llFavour;
    LinearLayout llComment;
}