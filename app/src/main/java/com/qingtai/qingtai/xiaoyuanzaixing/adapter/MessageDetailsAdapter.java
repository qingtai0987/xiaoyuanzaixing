package com.qingtai.qingtai.xiaoyuanzaixing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.MessageDetailListViewBean;
import com.qingtai.qingtai.xiaoyuanzaixing.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/21.
 */
public class MessageDetailsAdapter extends BaseAdapter{

    private ArrayList<MessageDetailListViewBean> list ;
    private LayoutInflater layoutInflater;

    public MessageDetailsAdapter(Context context,ArrayList<MessageDetailListViewBean> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        MessageDetailListViewBean messageDetailListViewBean = list.get(position);
        return messageDetailListViewBean.getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            if(getItemViewType(i) == 0){
                viewHolder = new ViewHolder();
                view = layoutInflater.inflate(R.layout.item_message_details_in,null);
                viewHolder.icon = (ImageView)view.findViewById(R.id.icon_in);
                viewHolder.textView = (TextView)view.findViewById(R.id.text_in);

            }else {
                viewHolder = new ViewHolder();
                view = layoutInflater.inflate(R.layout.item_message_details_out,null);
                viewHolder.icon = (ImageView)view.findViewById(R.id.icon_out);
                viewHolder.textView = (TextView)view.findViewById(R.id.text_out);
            }
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.icon.setImageBitmap(list.get(i).getIcon());
        viewHolder.textView.setText(list.get(i).getText());
        return view;
    }
    public final class ViewHolder{
        public ImageView icon;
        public TextView textView;
    }
}
