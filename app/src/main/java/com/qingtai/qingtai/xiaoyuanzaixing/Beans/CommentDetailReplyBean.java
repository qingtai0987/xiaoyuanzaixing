package com.qingtai.qingtai.xiaoyuanzaixing.Beans;

/**
 * Created by Eafrey on 2017/1/5.
 */
public class CommentDetailReplyBean {
    String userName;
    String replyTime;
    String content;
    String toSomeone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToSomeone() {
        return toSomeone;
    }

    public void setToSomeone(String toSomeone) {
        this.toSomeone = toSomeone;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
