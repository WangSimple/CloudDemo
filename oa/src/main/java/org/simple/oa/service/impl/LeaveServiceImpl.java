package org.simple.oa.service.impl;

import com.google.common.collect.Maps;
import org.activiti.engine.task.Task;
import org.simple.oa.common.SimpleException;
import org.simple.oa.dto.LeaveDto;
import org.simple.oa.mapper.LeaveMapper;
import org.simple.oa.service.ActService;
import org.simple.oa.service.LeaveService;
import org.simple.oa.util.AuthUtil;
import org.simple.rbac.api.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class LeaveServiceImpl implements LeaveService{

    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private ActService actService;


    @Override
    @Transactional
    public void leaveApply(LeaveDto leaveDto) throws SimpleException{
        if (leaveDto==null){
            throw new SimpleException("请假申请参数有误.");
        }
        leaveDto.generalId();
        //TODO 访问RBAC系统获取员工直属领导
        UserDto currentUser= AuthUtil.getCurrentUser();
        String examineId="-1";
        //开启流程
        Map<String,Object> params= Maps.newHashMap();
        params.put("examineId",examineId);
        params.put("applyId",currentUser.getUserId());
        String title=currentUser.getUserName()+leaveDto.getLeaveType().getLabel()+"申请";
        String businessKey=leaveDto.getProcBusinessKey();
        String procInstId = actService.startProcess(LeaveDto.procInstKey, businessKey, title, params);
        Task leaveTask=actService.getAssignUserTasks(currentUser.getUserId(),businessKey,procInstId);
        if (leaveTask==null){
            throw new SimpleException("请假流程启动失败。");
        }
        actService.claimTask(leaveTask.getId(),currentUser.getUserId());
        String comments=currentUser.getUserName()+"提交"+leaveDto.getLeaveType().getLabel()+"申请";
        actService.completeTask(leaveTask.getId(),procInstId,comments,title,params);
        leaveDto.setProcInstId(procInstId);
        leaveDto.setUserId(currentUser.getUserId());
        leaveDto.setExamineId(examineId);
        leaveMapper.insert(leaveDto);
    }
}
