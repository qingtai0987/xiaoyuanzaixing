package com.qingtai.qingtai.xiaoyuanzaixing;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

public class SharePageActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_share_page);

        findView();

        initView();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
    }

    private void findView() {
        mToolbar = ((Toolbar) findViewById(R.id.toolbar_sharepage));
    }
}
