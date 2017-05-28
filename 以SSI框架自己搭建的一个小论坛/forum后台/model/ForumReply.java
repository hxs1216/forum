package com.nuchina.forum.model;

import java.util.Date;

public class ForumReply {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 意见表id
     */
    private Integer infoId;

    /**
     * 回复人id
     */
    private String replyId;

    /**
     * 回复人名字
     */
    private String replyName;

    /**
     *  回复时间
     */
    private Date replyTime;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 楼层
     */
    private Long replyPublicity;

    /**
     * 评论表的id
     */
    private Integer selfId;

    /**
     * 头像
     */
    private String extend1;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 屏蔽状态(1、屏蔽  0、非屏蔽)
     */
    private Integer shieldStatus;

    /**
     * 获取 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置   主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 意见表id
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * 设置   意见表id
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * 获取 回复人id
     */
    public String getReplyId() {
        return replyId;
    }

    /**
     * 设置   回复人id
     */
    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    /**
     * 获取 回复人名字
     */
    public String getReplyName() {
        return replyName;
    }

    /**
     * 设置   回复人名字
     */
    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    /**
     * 获取  回复时间
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * 设置    回复时间
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 获取 回复内容
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 设置   回复内容
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    /**
     * 获取 楼层
     */
    public Long getReplyPublicity() {
        return replyPublicity;
    }

    /**
     * 设置   楼层
     */
    public void setReplyPublicity(Long replyPublicity) {
        this.replyPublicity = replyPublicity;
    }

    /**
     * 获取 评论表的id
     */
    public Integer getSelfId() {
        return selfId;
    }

    /**
     * 设置   评论表的id
     */
    public void setSelfId(Integer selfId) {
        this.selfId = selfId;
    }

    /**
     * 获取 头像
     */
    public String getExtend1() {
        return extend1;
    }

    /**
     * 设置   头像
     */
    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    /**
     * 获取 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置   昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取 屏蔽状态(1、屏蔽  0、非屏蔽)
     */
    public Integer getShieldStatus() {
        return shieldStatus;
    }

    /**
     * 设置   屏蔽状态(1、屏蔽  0、非屏蔽)
     */
    public void setShieldStatus(Integer shieldStatus) {
        this.shieldStatus = shieldStatus;
    }
}