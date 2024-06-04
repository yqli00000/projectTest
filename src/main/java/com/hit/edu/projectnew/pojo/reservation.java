package com.hit.edu.projectnew.pojo;

import org.springframework.data.relational.core.sql.In;

public class reservation {
    private Integer CID;
    private Integer occuStatus;
    private Integer occuTime;
    private String reservations;
    private String reason;

    public reservation() {
    }

    public reservation(Integer CID, Integer occuStatus, Integer occuTime, String reservations, String reason) {
        this.CID = CID;
        this.occuStatus = occuStatus;
        this.occuTime = occuTime;
        this.reservations = reservations;
        this.reason = reason;
    }

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public Integer getOccuStatus() {
        return occuStatus;
    }

    public void setOccuStatus(Integer occuStatus) {
        this.occuStatus = occuStatus;
    }

    public Integer getOccuTime() {
        return occuTime;
    }

    public void setOccuTime(Integer occuTime) {
        this.occuTime = occuTime;
    }

    public String getReservations() {
        return reservations;
    }

    public void setReservations(String reservations) {
        this.reservations = reservations;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "reservation{" +
                "CID=" + CID +
                ", occuStatus=" + occuStatus +
                ", occuTime=" + occuTime +
                ", reservations='" + reservations + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
