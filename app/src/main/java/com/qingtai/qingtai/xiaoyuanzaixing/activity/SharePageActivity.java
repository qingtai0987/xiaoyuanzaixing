package com.qingtai.qingtai.xiaoyuanzaixing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.SharePageReplyBean;
import com.qingtai.qingtai.xiaoyuanzaixing.R;
import com.qingtai.qingtai.xiaoyuanzaixing.adapter.SharePageReplyAdapter;
import com.qingtai.qingtai.xiaoyuanzaixing.widget.ListViewInScrollView;

import java.util.LinkedList;
import java.util.List;

public class SharePageActivity extends AppCompatActivity implements View.OnClickListener{

    //此界面的toolbar
    private Toolbar mToolbar;
    //帖子详情
    private TextView tvContent;
    //用户名
    private TextView tvUserName;
    //帖子标题
    private TextView tvTitle;
    //帖子发布时间
    private TextView tvTime;
    //收藏帖子
    private TextView tvCollect;
    //回复帖子
    private TextView tvReply;
    //帖子回复列表控件
    private ListViewInScrollView lvReplyList;
    //帖子回复数据
    private List<SharePageReplyBean> replyListData = new LinkedList<>();;
    private ScrollView scrollViewContent;
    private TextView tvToolbarReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_share_page);

        findView();

        initData();

        initView();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //模拟数据
        for(int i = 0; i < 8; i++) {
            SharePageReplyBean msg = new SharePageReplyBean();
            msg.setCommentCount("2");
            msg.setFavourCount("6");
            int c = i + 1;
            msg.setReply("示例回复第"+ c +"个 得到我few分为氛围分为分为个人股恶搞二哥而过热个染发过热个如果二哥个人个个人过热过热过热过热二婚头和外国的风骨有空");
            msg.setReplyTime("2016-12-23 16:55");
            msg.setUserName("USERID");

            replyListData.add(msg);
        }

    }

    /**
     * 初始化各个view控件
     */
    private void initView() {
        //setSupportActionBar(mToolbar);
        //暂时写为以下文本
        tvContent.setText("\n\n\n\n\n\n\n\n\n\n\n          帖子详情\n\n\n\n\n\n\n\n\n\n");

        //评论列表控件listview设置适配器
        lvReplyList.setAdapter(new SharePageReplyAdapter(SharePageActivity.this, replyListData));

        //设置点击事件
        tvReply.setOnClickListener(this);
        tvCollect.setOnClickListener(this);

        initToolbar();
    }


    /**
     * 初始化toolbar相关操作
     */
    private void initToolbar() {
        //设置溢出菜单
        mToolbar.inflateMenu(R.menu.popup_menu_share_page);

        //设置溢出菜单的点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.popupmenu_share_page:
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        //设置点击toolbar上的返回键返回主页面
        tvToolbarReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 从xml布局文件中找到控件
     */
    private void findView() {
        tvToolbarReturn = ((TextView) findViewById(R.id.tv_share_page_toolbar_return));
        mToolbar = ((Toolbar) findViewById(R.id.toolbar_sharepage));
        tvContent = ((TextView) findViewById(R.id.tv_share_page_content));
        tvUserName = ((TextView) findViewById(R.id.tv_share_page_user_name));
        tvTitle = ((TextView) findViewById(R.id.tv_share_page_title));
        tvTime = ((TextView) findViewById(R.id.tv_share_page_time));
        tvCollect = ((TextView) findViewById(R.id.tv_share_page_bottom_collect));
        tvReply = ((TextView) findViewById(R.id.tv_share_page_bottom_reply));
        lvReplyList = ((ListViewInScrollView) findViewById(R.id.listview_share_page_relpy_content));
        scrollViewContent = ((ScrollView) findViewById(R.id.scrollview_share_page));
    }


    /**
     * 各个控件的点击事件
     * @param v 被点击的控件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击回复按钮后的点击事件
            case R.id.tv_share_page_bottom_reply:
                Intent intent = new Intent(SharePageActivity.this, WriteReplyActivity.class);
                startActivity(intent);
                break;
            //点击收藏按钮后的点击事件
            case R.id.tv_share_page_bottom_collect:
                break;
            default:
                break;
        }
    }
}
