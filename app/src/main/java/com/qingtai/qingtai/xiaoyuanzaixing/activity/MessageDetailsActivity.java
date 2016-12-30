package com.qingtai.qingtai.xiaoyuanzaixing.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.MessageDetailListViewBean;
import com.qingtai.qingtai.xiaoyuanzaixing.R;
import com.qingtai.qingtai.xiaoyuanzaixing.adapter.MessageDetailsAdapter;

import java.util.ArrayList;

public class MessageDetailsActivity extends AppCompatActivity {

    private ListView mListView;
    private MessageDetailsAdapter adapter ;
    private ArrayList<MessageDetailListViewBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_details);
        initData();
        initView();

        mListView.setAdapter(adapter);
        mListView.setSelection(list.size()-1);
    }
    //初始化数据，初始化数据要在初始化控件之前进行
    public void initData(){
        list = new ArrayList<MessageDetailListViewBean>();
        MessageDetailListViewBean bean1 = new MessageDetailListViewBean();
        bean1.setIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        bean1.setText("Hello");
        bean1.setType(0);
        list.add(bean1);
        MessageDetailListViewBean bean2 = new MessageDetailListViewBean();
        bean2.setIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        bean2.setText("Hello,how are you?");
        bean2.setType(1);
        list.add(bean2);
        MessageDetailListViewBean bean3 = new MessageDetailListViewBean();
        bean3.setIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        bean3.setText("I am fine ,thank youfabhnfvsdbvfhvsahvdbcvhjavskjdfdggfhagforioefaurgfeauofouegfug");
        bean3.setType(0);
        list.add(bean3);
        MessageDetailListViewBean bean4 = new MessageDetailListViewBean();
        bean4.setIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        bean4.setText("you are welcome");
        bean4.setType(1);
        list.add(bean4);
        MessageDetailListViewBean bean5 = new MessageDetailListViewBean();
        bean5.setIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        bean5.setText("you are welcome");
        bean5.setType(1);
        list.add(bean5);
    }
    //初始化控件
    public void initView(){
        mListView = (ListView)findViewById(R.id.aty_messagedetail_lv);
        adapter = new MessageDetailsAdapter(getApplicationContext(),list);

    }

}
