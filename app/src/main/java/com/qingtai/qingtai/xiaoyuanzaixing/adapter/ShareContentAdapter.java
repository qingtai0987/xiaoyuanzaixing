package com.qingtai.qingtai.xiaoyuanzaixing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.ShareMessage;
import com.qingtai.qingtai.xiaoyuanzaixing.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */
public class ShareContentAdapter extends BaseAdapter {
    private List<ShareMessage> mList;
    private Context context;
    private ListView listView;

    public ShareContentAdapter(List<ShareMessage> mList, Context context, ListView listView) {
        this.mList = mList;
        this.context = context;
        this.listView = listView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder ;
        ShareMessage message = mList.get(i);
        if(view == null){

            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_share,null);
            viewHolder.imageView = (ImageView)view.findViewById(R.id.image_user_share);
            viewHolder.title = (TextView)view.findViewById(R.id.title);
            viewHolder.content = (TextView)view.findViewById(R.id.content);
            viewHolder.replyNum = (TextView)view.findViewById(R.id.repley_count);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.title.setText(message.getArticle_title());
        viewHolder.content.setText(message.getArticle_content());
        viewHolder.replyNum.setText(message.getReply_count());
        return view;
    }
    public  class ViewHolder{
        ImageView imageView;
        TextView nick_name;
        TextView label;
        TextView title;
        TextView content;
        TextView replyNum;
    }
}
