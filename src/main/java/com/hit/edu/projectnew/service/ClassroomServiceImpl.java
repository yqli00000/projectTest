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

//    public void updateClassroomStatus(int CID, boolean newStatus) {
//        classroomMapper.updateClassroomStatus(CID, newStatus);
//    }
    public void updataClassroom(classroom classroom){
        classroomMapper.updateClassroom(classroom);
    }
    // 检查数据库中是否存在指定 CID 的教室记录
    public boolean checkClassroomExists(Integer CID) {
        // 调用 ClassroomMapper 中的方法来查询数据库
        classroom classroom = classroomMapper.findClassroomById(CID);
        // 如果查询结果不为空，则表示数据库中存在指定 CID 的记录
        return classroom != null;
    }
}
