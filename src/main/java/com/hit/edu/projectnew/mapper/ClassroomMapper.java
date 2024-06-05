package com.hit.edu.projectnew.mapper;

import com.hit.edu.projectnew.pojo.classroom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassroomMapper {
//    查询全部内容
//    @Select("select * from classroom")
//    public List<classroom> list();


    @Select("SELECT * FROM classroom")
    List<classroom> findAllClassrooms();

    @Insert("INSERT INTO classroom (CID, content, building, campus, equipment) VALUES (#{CID}, #{content}, #{building}, #{campus}, #{equipment})")
//    @Options(useGeneratedKeys = true, keyProperty = "CID")
    void addClassroom(classroom classroom);

    @Delete("DELETE FROM classroom WHERE CID = #{CID}")
    void deleteClassroom(int CID);
}
