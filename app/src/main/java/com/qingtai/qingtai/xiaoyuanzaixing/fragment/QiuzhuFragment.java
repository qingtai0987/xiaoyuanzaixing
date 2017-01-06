package com.qingtai.qingtai.xiaoyuanzaixing.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.QiuzhuMessage;
import com.qingtai.qingtai.xiaoyuanzaixing.R;
import com.qingtai.qingtai.xiaoyuanzaixing.adapter.QiuzhutieAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QiuzhuFragment extends Fragment {

    private ListView qiuzhuListView;
    private View view;
    private List<QiuzhuMessage> datalist = new ArrayList<>();
    private QiuzhutieAdapter adapter ;


    public QiuzhuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qiuzhu, container, false);
        qiuzhuListView = (ListView)view.findViewById(R.id.frg_qiuzhu_lv);
        initData();
        qiuzhuListView = (ListView)view.findViewById(R.id.frg_qiuzhu_lv);
        QiuzhutieAdapter adapter = new QiuzhutieAdapter(datalist,getContext(),qiuzhuListView);
        qiuzhuListView.setAdapter(adapter);
        return view;
    }
    public void initData(){
        datalist = new ArrayList<>();
        for(int i =0; i < 5; i ++){
            QiuzhuMessage message = new QiuzhuMessage();
            message.setArticle_title("标题");
            message.setArticle_content("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
            message.setReply_count("50");
            message.setType(1);
            datalist.add(message);
        }
        for(int i =5; i < 10; i ++){
            QiuzhuMessage message = new QiuzhuMessage();
            message.setArticle_title("标题");
            message.setArticle_content("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
            message.setReply_count("50");
            message.setType(0);

            datalist.add(message);
        }
        for(int i =10; i < 15; i ++){
            QiuzhuMessage message = new QiuzhuMessage();
            message.setArticle_title("标题");
            message.setArticle_content("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
            message.setReply_count("23");
            message.setType(0);

            datalist.add(message);
        }

    }


}
