package com.qingtai.qingtai.xiaoyuanzaixing.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.ShareMessage;
import com.qingtai.qingtai.xiaoyuanzaixing.R;
import com.qingtai.qingtai.xiaoyuanzaixing.activity.SharePageActivity;
import com.qingtai.qingtai.xiaoyuanzaixing.adapter.ShareContentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FenxiangFragment extends Fragment {

    private ListView mListView;
    private View view;
    private ShareContentAdapter adapter;
    private List<ShareMessage> mList;


    public FenxiangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view = inflater.inflate(R.layout.fragment_fenxiang, container, false);
        initView();
        initData();
        adapter = new ShareContentAdapter(mList,getContext(),mListView);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),SharePageActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public void initData(){
        mList = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            ShareMessage message = new ShareMessage();
            message.setArticle_title("这是标题");
            message.setArticle_content("这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容这是内容");
            message.setReply_count("20");
            mList.add(message);

        }
    }
    private void initView(){
        mListView = (ListView)view.findViewById(R.id.frg_share_lv);

    }

}
