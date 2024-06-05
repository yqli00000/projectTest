package com.hit.edu.projectnew.service;

import com.hit.edu.projectnew.pojo.classroom;
import com.hit.edu.projectnew.mapper.ClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;

    public List<classroom> findAllClassrooms() {
        return classroomMapper.findAllClassrooms();
    }

    public void addClassroom(classroom classroom) {
        classroomMapper.addClassroom(classroom);
    }
    public void deleteClassroom(Integer CID){
        classroomMapper.deleteClassroom(CID);
    }
}
