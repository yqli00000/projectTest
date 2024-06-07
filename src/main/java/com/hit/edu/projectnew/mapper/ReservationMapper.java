package com.hit.edu.projectnew.mapper;

import com.hit.edu.projectnew.pojo.checklist;
import com.hit.edu.projectnew.pojo.reservation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReservationMapper {
    @Insert("INSERT INTO reservation (CID, occuStatus, occuTime, reservations, reason, type, dateTime) VALUES (#{CID}, #{occuStatus}, #{occuTime}, #{reservations}, #{reason}, #{type}, #{dateTime})")
    void insertReservation(reservation reservation);
    @Update("UPDATE reservation SET occuStatus = type WHERE CID=#{CID} and occuTime=#{occuTime} and dateTime= #{dateTime}")
    void copyTypeToOccuStatus(checklist checklist);
    @Select("SELECT r.* FROM reservation r " +
            "JOIN checklist c ON r.CID = c.CID AND r.dateTime = c.dateTime AND r.occuTime = c.occuTime " +
            "WHERE c.checkStatus = 0")
    List<reservation> getNoReservations();

    @Select("SELECT r.* FROM reservation r " +
            "JOIN checklist c ON r.CID = c.CID AND r.dateTime = c.dateTime AND r.occuTime = c.occuTime " +
            "WHERE c.checkStatus IN (1, 2)")
    List<reservation> getYesReservations();
}
