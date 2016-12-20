package com.qingtai.qingtai.xiaoyuanzaixing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.QiuzhuMessage;
import com.qingtai.qingtai.xiaoyuanzaixing.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
public class QiuzhutieAdapter extends BaseAdapter {
    private List<QiuzhuMessage> dataList;
    private Context context;
    private ListView mListView;

    public QiuzhutieAdapter(List<QiuzhuMessage> dataList, Context context, ListView mListView) {
        this.dataList = dataList;
        this.context = context;
        this.mListView = mListView;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        final int type = getItemViewType(i);
        switch (type){
            case 0:
                final ViewHolder viewHolder;
                final QiuzhuMessage message = dataList.get(i);
                if(convertview == null){
                    convertview = LayoutInflater.from(context).inflate(R.layout.item_qiuzhu,null);
                    viewHolder = new ViewHolder();
                    viewHolder.image_author = (ImageView)convertview.findViewById(R.id.image_user);
                    viewHolder.tv_article_title = (TextView)convertview.findViewById(R.id.biaoti);
                    viewHolder.tv_article_content = (TextView)convertview.findViewById(R.id.content);
                    viewHolder.tv_reply_count = (TextView)convertview.findViewById(R.id.repley_count);
                    convertview.setTag(viewHolder);

                }else {
                    viewHolder = (ViewHolder)convertview.getTag();
                }
                viewHolder.tv_article_title.setText(message.getArticle_title());
                viewHolder.tv_article_content.setText(message.getArticle_content());
                viewHolder.tv_reply_count.setText(message.getReply_count());
        }

        return convertview;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }
    static class ViewHolder{
        ImageView image_author;
        TextView tv_author_name;
        TextView tv_author_label;
        TextView tv_article_title;
        TextView tv_article_content;
        TextView tv_reply_count;
    }
}
