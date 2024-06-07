package com.hit.edu.projectnew.pojo;

import java.util.Date;

public class checklist {
    private Integer CID;
    private Integer occuTime;
    private Integer checkStatus;

    private Date dateTime;

    public checklist() {
    }

    public checklist(Integer CID, Integer occuTime, Integer checkStatus, Date dateTime) {
        this.CID = CID;
        this.occuTime = occuTime;
        this.checkStatus = checkStatus;
        this.dateTime = dateTime;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "checklist{" +
                "CID=" + CID +
                ", occuTime=" + occuTime +
                ", checkStatus=" + checkStatus +
                ", dateTime=" + dateTime +
                '}';
    }
}
