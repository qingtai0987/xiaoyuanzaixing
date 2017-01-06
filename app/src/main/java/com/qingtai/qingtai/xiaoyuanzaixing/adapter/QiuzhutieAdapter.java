package com.qingtai.qingtai.xiaoyuanzaixing.adapter;

import android.content.Context;
import android.media.Image;
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
                    viewHolder.imageView1 = (ImageView)convertview.findViewById(R.id.article_image1);
                    viewHolder.imageView2 = (ImageView)convertview.findViewById(R.id.article_image2);
                    viewHolder.imageView3 = (ImageView)convertview.findViewById(R.id.article_image3);
                    convertview.setTag(viewHolder);

                }else {
                    viewHolder = (ViewHolder)convertview.getTag();
                }
                viewHolder.tv_article_title.setText(message.getArticle_title());
                viewHolder.tv_article_content.setText(message.getArticle_content());
                viewHolder.tv_reply_count.setText(message.getReply_count());
                viewHolder.imageView1.setImageResource(R.mipmap.ic_launcher);
                viewHolder.imageView2.setImageResource(R.mipmap.ic_launcher);
                viewHolder.imageView3.setImageResource(R.mipmap.ic_launcher);

                break;
            case 1: //没有图片的布局显示
                final ViewHolder1 viewHolder1;
                final QiuzhuMessage message1 = dataList.get(i);
                if(convertview == null){
                    convertview = LayoutInflater.from(context).inflate(R.layout.item_qiiuzhu_no_image,null);
                    viewHolder1 = new ViewHolder1();
                    viewHolder1.image_author = (ImageView)convertview.findViewById(R.id.image_user);
                    viewHolder1.tv_article_title = (TextView)convertview.findViewById(R.id.biaoti);
                    viewHolder1.tv_article_content = (TextView)convertview.findViewById(R.id.content);
                    viewHolder1.tv_reply_count = (TextView)convertview.findViewById(R.id.repley_count);
                    convertview.setTag(viewHolder1);
                }
                else
                {
                    viewHolder1 =(ViewHolder1)convertview.getTag();
                }
                viewHolder1.tv_article_title.setText(message1.getArticle_title());
                viewHolder1.tv_article_content.setText(message1.getArticle_content());
                viewHolder1.tv_reply_count.setText(message1.getReply_count());
                break;
            case 2:
                final ViewHolder2 viewHolder2;
                final QiuzhuMessage message2 = dataList.get(i);
                if(convertview == null){
                    convertview = LayoutInflater.from(context).inflate(R.layout.item_qiuzhu1,null);
                    viewHolder2 = new ViewHolder2();
                    viewHolder2.image_author = (ImageView)convertview.findViewById(R.id.image_user);
                    viewHolder2.tv_article_title = (TextView)convertview.findViewById(R.id.biaoti);
                    viewHolder2.tv_article_content = (TextView)convertview.findViewById(R.id.content);
                    viewHolder2.tv_reply_count = (TextView)convertview.findViewById(R.id.repley_count);
                    viewHolder2.imageView1 = (ImageView)convertview.findViewById(R.id.article_image1);
                    convertview.setTag(viewHolder2);
                }
                else{
                    viewHolder2 = (ViewHolder2)convertview.getTag();
                }
                viewHolder2.tv_article_title.setText(message2.getArticle_title());
                viewHolder2.tv_article_content.setText(message2.getArticle_content());
                viewHolder2.tv_reply_count.setText(message2.getReply_count());
                viewHolder2.imageView1.setImageResource(R.mipmap.ic_launcher);
                break;
        }

        return convertview;
    }

    @Override
    public int getItemViewType(int position) {
        QiuzhuMessage message = dataList.get(position);
        return message.getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
    static class ViewHolder{  //有三张图片
        ImageView image_author;
        TextView tv_author_name;
        TextView tv_author_label;
        TextView tv_article_title;
        TextView tv_article_content;
        TextView tv_reply_count;
        ImageView imageView1 ;
        ImageView imageView2;
        ImageView imageView3;
    }
    static class ViewHolder1{ //没有图片
        ImageView image_author;
        TextView tv_author_name;
        TextView tv_author_label;
        TextView tv_article_title;
        TextView tv_article_content;
        TextView tv_reply_count;
    }
    static class ViewHolder2{  //有1张图片
        ImageView image_author;
        TextView tv_author_name;
        TextView tv_author_label;
        TextView tv_article_title;
        TextView tv_article_content;
        TextView tv_reply_count;
        ImageView imageView1 ;
    }
}
