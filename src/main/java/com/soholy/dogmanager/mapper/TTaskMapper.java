package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TTask;
import com.soholy.dogmanager.entity.TTaskExample;
import com.soholy.dogmanager.entity.notice.TaskDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTaskMapper {
    int countByExample(TTaskExample example);

    int deleteByExample(TTaskExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(TTask record);

    int insertSelective(TTask record);

    List<TTask> selectByExampleWithBLOBs(TTaskExample example);

    List<TTask> selectByExample(TTaskExample example);

    TTask selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") TTask record, @Param("example") TTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") TTask record, @Param("example") TTaskExample example);

    int updateByExample(@Param("record") TTask record, @Param("example") TTaskExample example);

    int updateByPrimaryKeySelective(TTask record);

    int updateByPrimaryKeyWithBLOBs(TTask record);

    int updateByPrimaryKey(TTask record);

    /**
     * 根据结构id查询機構的任务
     * @param orgId
     * @param taskStatus
     * @return
     */
    List<TaskDetail> findCollNotsByOrgId(@Param("orgId") int orgId, @Param("taskStatus") List<Integer> taskStatus);


}