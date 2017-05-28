package com.nuchina.forum.model;

public class ForumPraise {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * info表id
     */
    private Integer infoId;

    /**
     * 点赞用户id
     */
    private String praiseId;

    /**
     * 点赞用户名字
     */
    private String praiseName;

    private String extend1;

    /**
     * 昵称
     */
    private String nickName;

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
     * 获取 info表id
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * 设置   info表id
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * 获取 点赞用户id
     */
    public String getPraiseId() {
        return praiseId;
    }

    /**
     * 设置   点赞用户id
     */
    public void setPraiseId(String praiseId) {
        this.praiseId = praiseId;
    }

    /**
     * 获取 点赞用户名字
     */
    public String getPraiseName() {
        return praiseName;
    }

    /**
     * 设置   点赞用户名字
     */
    public void setPraiseName(String praiseName) {
        this.praiseName = praiseName;
    }

    public String getExtend1() {
        return extend1;
    }

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
}