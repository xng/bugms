package cc.cail.bugms.dao.entity;

import java.util.Date;

public class Bug {
    private Integer id;

    private Integer createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private String bugTitle;

    private Integer bugLevel;

    private Integer assignId;

    private Date assignTime;

    private Integer bugStatus;

    private String bak1;

    private String bak2;

    private String bugDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle == null ? null : bugTitle.trim();
    }

    public Integer getBugLevel() {
        return bugLevel;
    }

    public void setBugLevel(Integer bugLevel) {
        this.bugLevel = bugLevel;
    }

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public Integer getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(Integer bugStatus) {
        this.bugStatus = bugStatus;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    public String getBugDesc() {
        return bugDesc;
    }

    public void setBugDesc(String bugDesc) {
        this.bugDesc = bugDesc == null ? null : bugDesc.trim();
    }
}