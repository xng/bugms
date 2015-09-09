package cc.cail.bugms.dao.entity;

import java.util.Date;

public class BugLog {
    private Integer id;

    private Integer bugId;

    private Date updateTime;

    private Integer updateId;

    private String operation;

    private String opRemark;

    private String bak1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark == null ? null : opRemark.trim();
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }
    
    @Override
    public String toString() {
    	return "buglog : "+this.bugId+" / "+this.operation+" / "+this.opRemark;
    }
}