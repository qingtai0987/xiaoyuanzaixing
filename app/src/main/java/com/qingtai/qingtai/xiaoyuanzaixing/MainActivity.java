package com.qingtai.qingtai.xiaoyuanzaixing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.fragment.TieziFragment;
import com.qingtai.qingtai.xiaoyuanzaixing.fragment.FaxianFragment;
import com.qingtai.qingtai.xiaoyuanzaixing.fragment.PersonFragment;

import java.util.ArrayList;

/**
 * 用来显示主程序界面，
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener{


    private TextView mTiezi;
    private TextView mFaixan;
    private TextView mPersonal;

    private Fragment fragment;
    private static FragmentManager fragmentManager;
    private ArrayList<Fragment> fragmentArrayList;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        mTiezi.performClick();


    }

    @Override
    public void onClick(View view) {
        switchFragment(view);


    }

    //进行控件初始化
    private void initView(){
        mTiezi = (TextView)findViewById(R.id.aty_main_tiezi);
        mFaixan = (TextView)findViewById(R.id.aty_main_faxian);
        mPersonal = (TextView)findViewById(R.id.aty_main_person);
        mFaixan.setOnClickListener(this);
        mPersonal.setOnClickListener(this);
        mTiezi.setOnClickListener(this);

        mTiezi.setTag(0);
        mFaixan.setTag(1);
        mPersonal.setTag(2);

        fragmentManager = getSupportFragmentManager();
    }

    //把fragment都进行初始化，并添加到集合中
    private void initFragment(){
        fragmentArrayList = new ArrayList<Fragment>(3);
//        fragmentArrayList.add(new TieziFragment());
        fragmentArrayList.add(new TieziFragment());
        fragmentArrayList.add(new FaxianFragment());

        fragmentArrayList.add(new PersonFragment());
    }
    private void switchFragment(View v){
        currentIndex = (int)v.getTag();
        switch (currentIndex){
            case 0:
                selected();
                mTiezi.setSelected(true);
                break;
            case 1:
                selected();
                mFaixan.setSelected(true);
                break;
            case 2:
                selected();
                mPersonal.setSelected(true);
        }
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if(fragment != null){
            ft.hide(fragment);
        }
        Fragment nowFragment = fragmentManager.findFragmentByTag(fragmentArrayList.get(currentIndex).getClass().getName());
        if(nowFragment == null){
            nowFragment = fragmentArrayList.get(currentIndex);
        }
        fragment = nowFragment ;
        if(!nowFragment.isAdded()){
            ft.add(R.id.aty_main_fragment,nowFragment,nowFragment.getClass().getName());

        }
        else {
            ft.show(nowFragment);
        }
        ft.commit();

    }
    //重置所有按钮的选中状态
    public void selected(){
        mFaixan.setSelected(false);
        mTiezi.setSelected(false);
        mPersonal.setSelected(false);
    }
}
