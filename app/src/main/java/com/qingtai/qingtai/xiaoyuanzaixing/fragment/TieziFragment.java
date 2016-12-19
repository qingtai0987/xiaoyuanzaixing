package com.qingtai.qingtai.xiaoyuanzaixing.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qingtai.qingtai.xiaoyuanzaixing.R;
import com.qingtai.qingtai.xiaoyuanzaixing.adapter.FragmentAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class TieziFragment extends Fragment implements View.OnClickListener {

    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private View view;
    private TextView mQiuzhu,mFenxiang;
    private Fragment fragment;

    private FragmentManager fragmentManager;

    private int currentIndex = 0;

    public TieziFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tiezi, container, false);
        initView();
        init();
        mFenxiang.performClick();
        return view;
    }
    private void initView(){
        mFenxiang = (TextView) view.findViewById(R.id.frg_share);
        mQiuzhu = (TextView) view.findViewById(R.id.frg_qiuzhu);
        mFenxiang.setOnClickListener(this);
        mQiuzhu.setOnClickListener(this);
        mQiuzhu.setTag(0);
        mFenxiang.setTag(1);
        fragmentManager = getActivity().getSupportFragmentManager();

    }
    private void init(){
        mFragmentList.add(new QiuzhuFragment());
        mFragmentList.add(new FenxiangFragment());
    }

    @Override
    public void onClick(View view) {
        switchFragment(view);

    }
    private void switchFragment(View v){
        currentIndex = (int)v.getTag();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        if(fragment != null){
            ft.hide(fragment);
        }
        Fragment nowFragment = fragmentManager.findFragmentByTag(mFragmentList.get(currentIndex).getClass().getName());
        if(nowFragment == null){
            nowFragment = mFragmentList.get(currentIndex);
        }
        fragment = nowFragment ;
        if(!nowFragment.isAdded()){
            ft.add(R.id.frg_framentLayout,nowFragment,nowFragment.getClass().getName());

        }
        else {
            ft.show(nowFragment);
        }
        ft.commit();

    }

}
