package com.hit.edu.projectnew.service;

import com.hit.edu.projectnew.mapper.ReservationMapper;
import com.hit.edu.projectnew.pojo.checklist;
import com.hit.edu.projectnew.pojo.reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationMapper reservationMapper;
    // 预约
    public void addReservation(reservation reservation) {
        reservationMapper.insertReservation(reservation);
    }

    public void copyTypeToOccuStatus(checklist checklist) {
        reservationMapper.copyTypeToOccuStatus(checklist);
    }
    public List<reservation> getAllReservations() {
        return reservationMapper.getAllReservations();
    }
}
