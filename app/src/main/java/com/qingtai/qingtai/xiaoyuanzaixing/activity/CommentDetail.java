package com.qingtai.qingtai.xiaoyuanzaixing.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.qingtai.qingtai.xiaoyuanzaixing.Beans.CommentDetailReplyBean;
import com.qingtai.qingtai.xiaoyuanzaixing.R;
import com.qingtai.qingtai.xiaoyuanzaixing.adapter.CommentDetailReplyAdapter;
import com.qingtai.qingtai.xiaoyuanzaixing.widget.ListViewInScrollView;

import java.util.LinkedList;
import java.util.List;

public class CommentDetail extends AppCompatActivity implements View.OnClickListener{

    private TextView tvToolbarReturn;
    private ListViewInScrollView lvReplyComment;

    List<CommentDetailReplyBean> replyComments = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_detail);

        findView();

        initData();

        initView();
    }

    private void initView() {
        tvToolbarReturn.setOnClickListener(this);
        lvReplyComment.setAdapter(new CommentDetailReplyAdapter(this, replyComments));
    }

    private void initData() {
        for (int i=0; i<3; i++) {
            CommentDetailReplyBean data = new CommentDetailReplyBean();
            data.setContent("分为氛围分为违法范围截图");
            data.setUserName("XXX");
            data.setReplyTime("2017.1.5");
            if(i == 1) {
                data.setContent("回复XXX：分为氛围分为工会人体有");
            }
            data.setToSomeone("");
            replyComments.add(data);
        }
    }

    private void findView() {
        tvToolbarReturn = ((TextView) findViewById(R.id.tv_comment_detail_toolbar_return));
        lvReplyComment = ((ListViewInScrollView) findViewById(R.id.lv_comment_detail_reply_comment));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_comment_detail_toolbar_return:
                finish();
                break;
            default:
                break;
        }
    }
}
