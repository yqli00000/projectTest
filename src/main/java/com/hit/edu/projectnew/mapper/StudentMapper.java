package com.hit.edu.projectnew.mapper;

import com.hit.edu.projectnew.pojo.student;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    @Select("SELECT * FROM student WHERE sid = #{sid}")
    student findStudentById(String sid);
}
