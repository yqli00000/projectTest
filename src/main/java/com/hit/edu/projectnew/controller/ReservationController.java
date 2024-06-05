package com.hit.edu.projectnew.controller;

import com.hit.edu.projectnew.pojo.checklist;
import com.hit.edu.projectnew.pojo.reservation;
import com.hit.edu.projectnew.service.ChecklistService;
import com.hit.edu.projectnew.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ChecklistService checklistService;

    @RequestMapping("/reserveClassroom")
    @PostMapping
    public Map<String, Object> reserveClassroom(@RequestBody Map<String, String> reservationInfo) {
        Map<String, Object> response = new HashMap<>();
        Integer CID = Integer.parseInt(reservationInfo.get("CID"));
        Integer occuStatus = 1;
        Integer occuTime = Integer.parseInt(reservationInfo.get("occuTime"));
        String reservations = reservationInfo.get("reservations");
        String reason = reservationInfo.get("reason");
        Integer type = Integer.parseInt(reservationInfo.get("type"));
        Integer checkStatus = 0;

        reservation reservation = new reservation();
        checklist checklist = new checklist();

        reservation.setCID(CID);
        reservation.setOccuStatus(occuStatus);
        reservation.setOccuTime(occuTime);
        reservation.setReservations(reservations);
        reservation.setReason(reason);
        reservation.setType(type);

        checklist.setCID(CID);
        checklist.setOccuTime(occuTime);
        checklist.setCheckStatus(checkStatus);

        try {
            reservationService.addReservation(reservation);
            checklistService.addChecklist(checklist);
            response.put("success", true);
            response.put("message", "Reservation added successfully.");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to add reservation: " + e.getMessage());
        }

        return response;
    }
    @PutMapping("/updateChecklist")
//    @RequestMapping("/updateChecklist")
//    @PostMapping
    public Map<String, Object> updateChecklist(@RequestBody Map<String, String> checklistInfo) {
        Map<String, Object> response = new HashMap<>();
        try {
            Integer CID = Integer.parseInt(checklistInfo.get("CID"));
            Integer occuTime = Integer.parseInt(checklistInfo.get("occuTime"));
            Integer checkStatus = Integer.parseInt(checklistInfo.get("checkStatus"));

            checklist checklist = new checklist();
            checklist.setCID(CID);
            checklist.setOccuTime(occuTime);
            checklist.setCheckStatus(checkStatus);

            checklistService.updateChecklist(checklist);
            if (checkStatus==1){
                reservationService.copyTypeToOccuStatus(checklist);
            }
            response.put("success", true);
            response.put("message", "Checklist updated successfully.");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to update checklist: " + e.getMessage());
        }
        return response;
    }
    @GetMapping("/checkReservations")
    public Map<String, Object> getAllReservations() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<reservation> reservations = reservationService.getAllReservations();
            response.put("success", true);
            response.put("reservations", reservations);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to fetch reservations: " + e.getMessage());
        }
        return response;
    }
}
