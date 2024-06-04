package com.hit.edu.projectnew.pojo;

public class checklist {
    private Integer CID;
    private Integer occuTime;
    private Integer checkStatus;

    public checklist() {
    }

    public checklist(Integer CID, Integer occuTime, Integer checkStatus) {
        this.CID = CID;
        this.occuTime = occuTime;
        this.checkStatus = checkStatus;
    }

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public Integer getOccuTime() {
        return occuTime;
    }

    public void setOccuTime(Integer occuTime) {
        this.occuTime = occuTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public String toString() {
        return "checklist{" +
                "CID=" + CID +
                ", occuTime=" + occuTime +
                ", checkStatus=" + checkStatus +
                '}';
    }
}
