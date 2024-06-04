package com.hit.edu.projectnew.mapper;

import com.hit.edu.projectnew.pojo.classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassroomMapper {
//    查询全部内容
    @Select("select * from classroom")
    public List<classroom> list();

    @Select("select * from classsroom where CID=")
    public List<classroom> list(String CID);
}
