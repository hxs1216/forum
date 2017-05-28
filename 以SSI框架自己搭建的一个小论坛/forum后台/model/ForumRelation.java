package com.nuchina.forum.model;

import java.util.Date;

public class ForumRelation {
    private Integer id;

    /**
     * 我的昵称
     */
    private String myNickName;

    /**
     * 对方的昵称
     */
    private String herNickName;

    /**
     * 我的用户id
     */
    private String myUserId;

    /**
     * 对方的用户id
     */
    private String herUserId;

    /**
     * 标题
     */
    private String title;

    /**
     * 帖子id
     */
    private Integer publishId;

    /**
     * 时间
     */
    private Date relationTime;

    /**
     * 是否已经看过
     */
    private String alrealysee;

    private String extend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 我的昵称
     */
    public String getMyNickName() {
        return myNickName;
    }

    /**
     * 设置   我的昵称
     */
    public void setMyNickName(String myNickName) {
        this.myNickName = myNickName;
    }

    /**
     * 获取 对方的昵称
     */
    public String getHerNickName() {
        return herNickName;
    }

    /**
     * 设置   对方的昵称
     */
    public void setHerNickName(String herNickName) {
        this.herNickName = herNickName;
    }

    /**
     * 获取 我的用户id
     */
    public String getMyUserId() {
        return myUserId;
    }

    /**
     * 设置   我的用户id
     */
    public void setMyUserId(String myUserId) {
        this.myUserId = myUserId;
    }

    /**
     * 获取 对方的用户id
     */
    public String getHerUserId() {
        return herUserId;
    }

    /**
     * 设置   对方的用户id
     */
    public void setHerUserId(String herUserId) {
        this.herUserId = herUserId;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置   标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 帖子id
     */
    public Integer getPublishId() {
        return publishId;
    }

    /**
     * 设置   帖子id
     */
    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    /**
     * 获取 时间
     */
    public Date getRelationTime() {
        return relationTime;
    }

    /**
     * 设置   时间
     */
    public void setRelationTime(Date relationTime) {
        this.relationTime = relationTime;
    }

    /**
     * 获取 是否已经看过
     */
    public String getAlrealysee() {
        return alrealysee;
    }

    /**
     * 设置   是否已经看过
     */
    public void setAlrealysee(String alrealysee) {
        this.alrealysee = alrealysee;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}