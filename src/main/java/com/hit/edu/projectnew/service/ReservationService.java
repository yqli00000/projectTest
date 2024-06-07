package com.hit.edu.projectnew.service;

import com.hit.edu.projectnew.pojo.checklist;
import com.hit.edu.projectnew.pojo.reservation;

import java.util.List;

public interface ReservationService {
    public void addReservation(reservation reservation);
    public void copyTypeToOccuStatus(checklist checklist);
    public List<reservation> getNoReservations();
    public List<reservation> getYesReservations();
}
