package org.simple.oa.service.impl;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.StringUtils;
import org.simple.oa.service.ActService;
import org.simple.oa.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ActServiceImpl implements ActService{

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private TaskService taskService;

    @Override
    public String startProcess(String procInstKey,String businessKey,String title,Map<String,Object> params) {
        String userId= AuthUtil.getCurrentUser().getUserId();
        if (params==null){
            params= Maps.newHashMap();
        }
        if (StringUtils.isNotBlank(title)){
            params.put("title",title);
        }
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(procInstKey, businessKey, params);
        log.info("启动流程实例{}成功",processInstance.getId());
        log.info("流程定义ID{}",processInstance.getProcessDefinitionId());
        identityService.setAuthenticatedUserId(userId);
        return processInstance.getId();
    }

    @Override
    public List<Task> getUnclaimUserTasks(String assigns, String businessKey, String procInstId) {
        TaskQuery query = taskService.createTaskQuery().orderByTaskCreateTime().desc();
        //query.processInstanceId(procInstId);
        return query.list();
    }

    @Override
    public Task getAssignUserTasks(String assigns, String businessKey, String procInstId) {
        TaskQuery query = taskService.createTaskQuery().orderByTaskCreateTime().desc();
        query.taskAssignee(assigns);
        query.processInstanceBusinessKey(businessKey);
        query.processInstanceId(procInstId);
        return query.singleResult();
    }

    @Override
    public void claimTask(String taskId, String userId) {
        taskService.claim(taskId,userId);
        log.debug("{}签收任务{}",userId,taskId);
    }

    @Override
    public void completeTask(String taskId, String procInstId, String comments, Map<String, Object> vars) {
        this.completeTask(taskId,procInstId,comments,"",vars);

    }

    @Override
    public void completeTask(String taskId, String procInstId, String comments, String title, Map<String, Object> vars) {
        if (StringUtils.isNotBlank(procInstId)&&StringUtils.isNotBlank(comments)){
            taskService.addComment(taskId,procInstId,comments);
        }
        if (vars==null){
            vars= Maps.newHashMap();
        }
        if (StringUtils.isNotBlank(title)){
            vars.put("title",title);
        }
        taskService.complete(taskId,vars);
    }


}
