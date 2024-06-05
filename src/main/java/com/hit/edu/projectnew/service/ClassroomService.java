package com.hit.edu.projectnew.service;

import com.hit.edu.projectnew.pojo.classroom;
import java.util.List;
public interface ClassroomService {
//    public String getClassroomByCID(String CID);
    public List<classroom> findAllClassrooms();
    public void addClassroom(classroom classroom);
    public void deleteClassroom(Integer CID);
}
