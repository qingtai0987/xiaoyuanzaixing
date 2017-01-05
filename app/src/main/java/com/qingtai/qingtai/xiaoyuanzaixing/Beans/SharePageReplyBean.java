package com.qingtai.qingtai.xiaoyuanzaixing.Beans;

/**
 * Created by Eafrey on 2016/12/23.
 */
public class SharePageReplyBean {
    //用户名
    String userName;
    //回复内容
    String reply;
    //回复时间
    String replyTime;
    //赞的数量
    String favourCount;
    //评论的数量
    String commentCount;

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getFavourCount() {
        return favourCount;
    }

    public void setFavourCount(String favourCount) {
        this.favourCount = favourCount;
    }
}