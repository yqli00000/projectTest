package com.hit.edu.projectnew.service;

import com.hit.edu.projectnew.pojo.classroom;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
public interface ClassroomService {
    //    public String getClassroomByCID(String CID);
    public List<classroom> findAllClassrooms();

    public void addClassroom(classroom classroom);

    public void deleteClassroom(Integer CID);

//    public void updateClassroomStatus(int CID, boolean newStatus);
    public void updataClassroom(classroom classroom);

    public boolean checkClassroomExists(Integer CID);
}