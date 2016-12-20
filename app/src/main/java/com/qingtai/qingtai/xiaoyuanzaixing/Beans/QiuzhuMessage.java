package com.qingtai.qingtai.xiaoyuanzaixing.Beans;

/**
 * Created by Administrator on 2016/12/19.
 */
public class QiuzhuMessage {

    private String user_nickName;
    private String user_image_url;//用户头像
    private String label;//用户label
    private String article_title;
    private String article_content;
    private String[] article_image_urls;
    private String reply_count;

    public String getUser_nickName() {
        return user_nickName;
    }

    public void setUser_nickName(String user_nickName) {
        this.user_nickName = user_nickName;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public String[] getArticle_image_urls() {
        return article_image_urls;
    }

    public void setArticle_image_urls(String[] article_image_urls) {
        this.article_image_urls = article_image_urls;
    }

    public String getReply_count() {
        return reply_count;
    }

    public void setReply_count(String reply_count) {
        this.reply_count = reply_count;
    }
}
