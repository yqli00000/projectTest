package com.hit.edu.projectnew.controller;

import com.hit.edu.projectnew.pojo.checklist;
import com.hit.edu.projectnew.pojo.reservation;
import com.hit.edu.projectnew.service.ChecklistService;
import com.hit.edu.projectnew.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.sql.Date;
//import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
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
    public Map<String, Object> reserveClassroom(@RequestBody Map<String, String> reservationInfo) throws ParseException {
        Map<String, Object> response = new HashMap<>();
        Integer CID = Integer.parseInt(reservationInfo.get("CID"));
        Integer occuStatus = 1;
        Integer occuTime = Integer.parseInt(reservationInfo.get("occuTime"));
        String reservations = reservationInfo.get("reservations");
        String reason = reservationInfo.get("reason");
        Integer type = Integer.parseInt(reservationInfo.get("type"));
        String dateString = reservationInfo.get("dateTime"); // 假设前端传递的日期字段名为 "date"
//        Date dateTime = Date.valueOf(dateString);
        LocalDate dateTime = LocalDate.parse(dateString);
        Integer checkStatus = 0;
        System.out.println(dateString);
        System.out.println(dateTime);
        // 获取当前日期的Timestamp
//        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
//        // 获取七天后的日期的Timestamp
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(currentTimestamp);
//        calendar.add(Calendar.DAY_OF_YEAR, 7);
//        Timestamp sevenDaysLaterTimestamp = new Timestamp(calendar.getTimeInMillis());
//
//        // 检查预约时间是否在当前时间之后且在七天内
//        if (dateTime.before(currentTimestamp) || dateTime.after(sevenDaysLaterTimestamp)) {
//            response.put("success", false);
//            response.put("message", "Reservation time must be after the current time and within seven days.");
//            return response;
//        }

        // 获取当前日期和时间
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 获取七天后的日期和时间
        LocalDateTime sevenDaysLaterDateTime = currentDateTime.plusDays(7);
// 检查预约时间是否在当前时间之后且在七天内
        LocalDateTime reservationDateTime = dateTime.atTime(0, 0);
        if (reservationDateTime.isBefore(currentDateTime) || reservationDateTime.isAfter(sevenDaysLaterDateTime)) {
            response.put("success", false);
            response.put("message", "Reservation time must be after the current time and within seven days.");
            return response;
        }

        System.out.println(dateString);
        System.out.println(dateTime);


        reservation reservation = new reservation();
        checklist checklist = new checklist();

        reservation.setCID(CID);
        reservation.setOccuStatus(occuStatus);
        reservation.setOccuTime(occuTime);
        reservation.setReservations(reservations);
        reservation.setReason(reason);
        reservation.setType(type);
        reservation.setDateTime(dateTime);

        checklist.setCID(CID);
        checklist.setOccuTime(occuTime);
        checklist.setCheckStatus(checkStatus);
        checklist.setDateTime(dateTime);

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
            String dateString = checklistInfo.get("dateTime"); // 假设前端传递的日期字段名为 "date"
            Date dateTime = Date.valueOf(dateString);

            checklist checklist = new checklist();
            checklist.setCID(CID);
            checklist.setOccuTime(occuTime);
            checklist.setCheckStatus(checkStatus);
            checklist.setDateTime(dateTime);

            checklistService.updateChecklist(checklist);
//            审核通过
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
    @GetMapping("/checkReservationsNo")
    public Map<String, Object> getNoReservations() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<reservation> reservations = reservationService.getNoReservations();
            response.put("success", true);
            response.put("reservations", reservations);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to fetch reservations: " + e.getMessage());
        }
        return response;
    }
    @GetMapping("/checkReservationsYes")
    public Map<String, Object> getYesReservations() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<reservation> reservations = reservationService.getYesReservations();
            response.put("success", true);
            response.put("reservations", reservations);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to fetch reservations: " + e.getMessage());
        }
        return response;
    }
}
