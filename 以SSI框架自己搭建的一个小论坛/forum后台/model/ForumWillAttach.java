package com.nuchina.forum.model;

import java.util.Date;

public class ForumWillAttach {
    /**
     * 编号
     */
    private Integer attachid;

    /**
     * 附件所属申请单编号
     */
    private Long applyid;

    /**
     * 附件路劲
     */
    private String attachpath;

    /**
     * 附件上传时间
     */
    private Date uptime;

    /**
     * 附件上传人姓名
     */
    private String upusername;

    /**
     * 附件上传人编号
     */
    private String upuserid;

    /**
     * 附件名称
     */
    private String attachname;

    /**
     * 附件大小
     */
    private String attsize;

    /**
     * 附件上传时的流程所在环节名称
     */
    private String attstate;

    /**
     * 可见范围，id分隔
     */
    private String seeids;

    /**
     * 可见范围，name分隔
     */
    private String seenames;

    /**
     * 附件类型
     */
    private String attachtype;

    /**
     * 获取 编号
     */
    public Integer getAttachid() {
        return attachid;
    }

    /**
     * 设置   编号
     */
    public void setAttachid(Integer attachid) {
        this.attachid = attachid;
    }

    /**
     * 获取 附件所属申请单编号
     */
    public Long getApplyid() {
        return applyid;
    }

    /**
     * 设置   附件所属申请单编号
     */
    public void setApplyid(Long applyid) {
        this.applyid = applyid;
    }

    /**
     * 获取 附件路劲
     */
    public String getAttachpath() {
        return attachpath;
    }

    /**
     * 设置   附件路劲
     */
    public void setAttachpath(String attachpath) {
        this.attachpath = attachpath;
    }

    /**
     * 获取 附件上传时间
     */
    public Date getUptime() {
        return uptime;
    }

    /**
     * 设置   附件上传时间
     */
    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    /**
     * 获取 附件上传人姓名
     */
    public String getUpusername() {
        return upusername;
    }

    /**
     * 设置   附件上传人姓名
     */
    public void setUpusername(String upusername) {
        this.upusername = upusername;
    }

    /**
     * 获取 附件上传人编号
     */
    public String getUpuserid() {
        return upuserid;
    }

    /**
     * 设置   附件上传人编号
     */
    public void setUpuserid(String upuserid) {
        this.upuserid = upuserid;
    }

    /**
     * 获取 附件名称
     */
    public String getAttachname() {
        return attachname;
    }

    /**
     * 设置   附件名称
     */
    public void setAttachname(String attachname) {
        this.attachname = attachname;
    }

    /**
     * 获取 附件大小
     */
    public String getAttsize() {
        return attsize;
    }

    /**
     * 设置   附件大小
     */
    public void setAttsize(String attsize) {
        this.attsize = attsize;
    }

    /**
     * 获取 附件上传时的流程所在环节名称
     */
    public String getAttstate() {
        return attstate;
    }

    /**
     * 设置   附件上传时的流程所在环节名称
     */
    public void setAttstate(String attstate) {
        this.attstate = attstate;
    }

    /**
     * 获取 可见范围，id分隔
     */
    public String getSeeids() {
        return seeids;
    }

    /**
     * 设置   可见范围，id分隔
     */
    public void setSeeids(String seeids) {
        this.seeids = seeids;
    }

    /**
     * 获取 可见范围，name分隔
     */
    public String getSeenames() {
        return seenames;
    }

    /**
     * 设置   可见范围，name分隔
     */
    public void setSeenames(String seenames) {
        this.seenames = seenames;
    }

    /**
     * 获取 附件类型
     */
    public String getAttachtype() {
        return attachtype;
    }

    /**
     * 设置   附件类型
     */
    public void setAttachtype(String attachtype) {
        this.attachtype = attachtype;
    }
}