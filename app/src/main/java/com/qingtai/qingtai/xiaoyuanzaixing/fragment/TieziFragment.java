package com.qingtai.qingtai.xiaoyuanzaixing.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
    private FragmentAdapter mFragmentAdapter;
    public static ViewPager mViewPager;
    private View view;
    private TextView mQiuzhu,mFenxiang;

    private Fragment mQiuzhuFragment,mFenxiangFragment;

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
        return view;
    }
    private void initView(){
        mFenxiang = (TextView) view.findViewById(R.id.frg_share);
        mQiuzhu = (TextView) view.findViewById(R.id.frg_qiuzhu);
        mFenxiang.setOnClickListener(this);
        mQiuzhu.setOnClickListener(this);

//        mViewPager = (ViewPager)view.findViewById(R.id.frg_viewpager);


    }
    private void init(){
        mFragmentList.add(new QiuzhuFragment());
        mFragmentList.add(new FenxiangFragment());
//        mFragmentAdapter = new FragmentAdapter(getActivity().getSupportFragmentManager(),mFragmentList);
//        mViewPager.setAdapter(mFragmentAdapter);
//        mViewPager.setCurrentItem(1);
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                initColor();
//                switch (position){
//                    case 0:
//                        mQiuzhu.setTextColor(Color.BLUE);
//                        break;
//                    case 1:
//                        mFenxiang.setTextColor(Color.BLUE);
//                        break;
//                }
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.frg_share:
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.frg_framentLayout);
                if(fragment == null){
                    fragment = new FenxiangFragment();
                    fm.beginTransaction().add(R.id.frg_framentLayout,fragment).commit();
                }

        }

    }
//    private void initColor(){
//        mQiuzhu.setTextColor(Color.RED);
//        mFenxiang.setTextColor(Color.RED);
//    }
}
