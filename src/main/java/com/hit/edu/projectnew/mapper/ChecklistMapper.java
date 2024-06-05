package com.hit.edu.projectnew.mapper;

import com.hit.edu.projectnew.pojo.checklist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface ChecklistMapper {
    @Insert("INSERT INTO checklist (CID, occuTime,checkStatus) VALUES (#{CID}, #{occuTime}, #{checkStatus})")
    void insertChecklist(checklist checklist);

    @Update("UPDATE checklist SET checkStatus=#{checkStatus} WHERE CID=#{CID} and occuTime=#{occuTime}")
    void updateCHecklist(checklist checklist);
}
