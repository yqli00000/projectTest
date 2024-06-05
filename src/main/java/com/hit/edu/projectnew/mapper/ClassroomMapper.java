package com.hit.edu.projectnew.mapper;

import com.hit.edu.projectnew.pojo.classroom;
import com.hit.edu.projectnew.pojo.reservation;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClassroomMapper {
//    查询全部内容
//    @Select("select * from classroom")
//    public List<classroom> list();


    @Select("SELECT * FROM classroom")
    List<classroom> findAllClassrooms();
    @Select("SELECT * FROM classroom WHERE CID=#{CID}")
    classroom findClassroomById(Integer CID);
    @Insert("INSERT INTO classroom (CID, content, building, campus, equipment) VALUES (#{CID}, #{content}, #{building}, #{campus}, #{equipment})")
//    @Options(useGeneratedKeys = true, keyProperty = "CID")
    void addClassroom(classroom classroom);

    @Delete("DELETE FROM classroom WHERE CID = #{CID}")
    void deleteClassroom(int CID);

//    @Update("UPDATE classroom SET status = #{newStatus} WHERE CID = #{CID}")
//    void updateClassroomStatus(@Param("CID") int CID, @Param("newStatus") boolean newStatus);
    @Update("UPDATE classroom SET content = #{content}, building = #{building}, campus = #{campus}, equipment = #{equipment} WHERE CID = #{CID}")
//    @Update({
//            "<script>",
//            "UPDATE classroom",
//            "<set>",
//            "<if test='content != null'>content = #{content},</if>",
//            "<if test='building != null'>building = #{building},</if>",
//            "<if test='campus != null'>campus = #{campus},</if>",
//            "<if test='equipment != null'>equipment = #{equipment},</if>",
//            "</set>",
//            "WHERE CID = #{CID}",
//            "</script>"
//    })
    void updateClassroom(classroom classroom);
    @SelectProvider(type = ClassroomSqlProvider.class, method = "selectByConditions")
    List<classroom> selectByConditions(Map<String, Object> conditions);

    class ClassroomSqlProvider {
        public String selectByConditions(Map<String, Object> conditions) {
            return new SQL() {{
                SELECT("*");
                FROM("classroom");
                if (conditions.get("CID") != null) {
                    WHERE("CID = #{CID}");
                }
                if (conditions.get("content") != null) {
                    WHERE("content = #{content}");
                }
                if (conditions.get("building") != null) {
                    WHERE("building = #{building}");
                }
                if (conditions.get("campus") != null) {
                    WHERE("campus = #{campus}");
                }
            }}.toString();
        }
    }

}
