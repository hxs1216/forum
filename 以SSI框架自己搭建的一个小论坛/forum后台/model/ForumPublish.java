package com.nuchina.forum.model;

import java.util.Date;

public class ForumPublish {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片
     */
    private String picture;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 拟稿时间
     */
    private Date draftTime;

    /**
     * 拟稿人电话
     */
    private String drafterPhone;

    /**
     * 帖子类别
     */
    private String postSort;

    /**
     * 用户人编号
     */
    private String userId;

    /**
     * 用户人名称
     */
    private String userName;

    /**
     * 管理员昵称（当被编辑的时候）
     */
    private String userPhone;

    /**
     * 用户部门编号
     */
    private String userPartId;

    /**
     * 用户部门名称
     */
    private String userPartName;

    /**
     * 用户公司编号
     */
    private String userCmpId;

    /**
     * 用户公司名称
     */
    private String userCmpName;

    /**
     * 浏览量
     */
    private Long viewNum;

    /**
     * 点赞量
     */
    private Long praiseNum;

    /**
     * 回复量
     */
    private Long replyNum;

    /**
     * 回复状态(0未回复1已回复)
     */
    private Long replyStatus;

    /**
     * 是否被管理员编辑(1编辑 0 未编辑)
     */
    private Long isPublicity;

    /**
     * 是否置顶（0否1是）
     */
    private Long isStick;

    /**
     * 精华贴
     */
    private String bestTopic;

    /**
     * 字体颜色
     */
    private String color;

    /**
     * 置顶时间
     */
    private Date stickTime;

    /**
     * 精华时间
     */
    private Date bestTime;

    /**
     * 类别精确
     */
    private String sortDetail;

    /**
     * 获取 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置   主键
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置   内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取 图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置   图片
     */
    public void setPicture(String picture) {
        this.picture = picture;
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
     * 获取 拟稿时间
     */
    public Date getDraftTime() {
        return draftTime;
    }

    /**
     * 设置   拟稿时间
     */
    public void setDraftTime(Date draftTime) {
        this.draftTime = draftTime;
    }

    /**
     * 获取 拟稿人电话
     */
    public String getDrafterPhone() {
        return drafterPhone;
    }

    /**
     * 设置   拟稿人电话
     */
    public void setDrafterPhone(String drafterPhone) {
        this.drafterPhone = drafterPhone;
    }

    /**
     * 获取 帖子类别
     */
    public String getPostSort() {
        return postSort;
    }

    /**
     * 设置   帖子类别
     */
    public void setPostSort(String postSort) {
        this.postSort = postSort;
    }

    /**
     * 获取 用户人编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置   用户人编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户人名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置   用户人名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 管理员昵称（当被编辑的时候）
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置   管理员昵称（当被编辑的时候）
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取 用户部门编号
     */
    public String getUserPartId() {
        return userPartId;
    }

    /**
     * 设置   用户部门编号
     */
    public void setUserPartId(String userPartId) {
        this.userPartId = userPartId;
    }

    /**
     * 获取 用户部门名称
     */
    public String getUserPartName() {
        return userPartName;
    }

    /**
     * 设置   用户部门名称
     */
    public void setUserPartName(String userPartName) {
        this.userPartName = userPartName;
    }

    /**
     * 获取 用户公司编号
     */
    public String getUserCmpId() {
        return userCmpId;
    }

    /**
     * 设置   用户公司编号
     */
    public void setUserCmpId(String userCmpId) {
        this.userCmpId = userCmpId;
    }

    /**
     * 获取 用户公司名称
     */
    public String getUserCmpName() {
        return userCmpName;
    }

    /**
     * 设置   用户公司名称
     */
    public void setUserCmpName(String userCmpName) {
        this.userCmpName = userCmpName;
    }

    /**
     * 获取 浏览量
     */
    public Long getViewNum() {
        return viewNum;
    }

    /**
     * 设置   浏览量
     */
    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    /**
     * 获取 点赞量
     */
    public Long getPraiseNum() {
        return praiseNum;
    }

    /**
     * 设置   点赞量
     */
    public void setPraiseNum(Long praiseNum) {
        this.praiseNum = praiseNum;
    }

    /**
     * 获取 回复量
     */
    public Long getReplyNum() {
        return replyNum;
    }

    /**
     * 设置   回复量
     */
    public void setReplyNum(Long replyNum) {
        this.replyNum = replyNum;
    }

    /**
     * 获取 回复状态(0未回复1已回复)
     */
    public Long getReplyStatus() {
        return replyStatus;
    }

    /**
     * 设置   回复状态(0未回复1已回复)
     */
    public void setReplyStatus(Long replyStatus) {
        this.replyStatus = replyStatus;
    }

    /**
     * 获取 是否被管理员编辑(1编辑 0 未编辑)
     */
    public Long getIsPublicity() {
        return isPublicity;
    }

    /**
     * 设置   是否被管理员编辑(1编辑 0 未编辑)
     */
    public void setIsPublicity(Long isPublicity) {
        this.isPublicity = isPublicity;
    }

    /**
     * 获取 是否置顶（0否1是）
     */
    public Long getIsStick() {
        return isStick;
    }

    /**
     * 设置   是否置顶（0否1是）
     */
    public void setIsStick(Long isStick) {
        this.isStick = isStick;
    }

    /**
     * 获取 精华贴
     */
    public String getBestTopic() {
        return bestTopic;
    }

    /**
     * 设置   精华贴
     */
    public void setBestTopic(String bestTopic) {
        this.bestTopic = bestTopic;
    }

    /**
     * 获取 字体颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置   字体颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取 置顶时间
     */
    public Date getStickTime() {
        return stickTime;
    }

    /**
     * 设置   置顶时间
     */
    public void setStickTime(Date stickTime) {
        this.stickTime = stickTime;
    }

    /**
     * 获取 精华时间
     */
    public Date getBestTime() {
        return bestTime;
    }

    /**
     * 设置   精华时间
     */
    public void setBestTime(Date bestTime) {
        this.bestTime = bestTime;
    }

    /**
     * 获取 类别精确
     */
    public String getSortDetail() {
        return sortDetail;
    }

    /**
     * 设置   类别精确
     */
    public void setSortDetail(String sortDetail) {
        this.sortDetail = sortDetail;
    }
}