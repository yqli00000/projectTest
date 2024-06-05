package com.hit.edu.projectnew.mapper;

import com.hit.edu.projectnew.pojo.checklist;
import com.hit.edu.projectnew.pojo.reservation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReservationMapper {
    @Insert("INSERT INTO reservation (CID, occuStatus, occuTime, reservations, reason, type) VALUES (#{CID}, #{occuStatus}, #{occuTime}, #{reservations}, #{reason}, #{type})")
    void insertReservation(reservation reservation);
    @Update("UPDATE reservation SET occuStatus = type WHERE CID=#{CID} and occuTime=#{occuTime}")
    void copyTypeToOccuStatus(checklist checklist);
    @Select("SELECT * FROM reservation")
    List<reservation> getAllReservations();
}
