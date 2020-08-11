package org.simple.oa.service;

import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

public interface ActService {
    String startProcess(String procInstKey,String businessKey,String title,Map<String,Object> params);
    /*
     * @Description 获取未签收任务
     * @param assigns
	 * @param businessKey
	 * @param procInstId
     * @return java.util.List<org.activiti.engine.task.Task>
     * @author xpWang
     * @date 2020/8/8 16:29
     */
    List<Task> getUnclaimUserTasks(String assigns, String businessKey, String procInstId);
    /*
     * @Description 查询出已经分配的任务列表
     * @param assigns
	 * @param businessKey
	 * @param procInstId
     * @return java.util.List<org.activiti.engine.task.Task>
     * @author xpWang
     * @date 2020/8/10 20:39
     */
    Task getAssignUserTasks(String assigns, String businessKey, String procInstId) ;
    void claimTask(String taskId,String userId);
    void completeTask(String taskId,String procInstId,String comments,Map<String,Object> vars);
    void completeTask(String taskId,String procInstId,String comments,String title,Map<String,Object> vars);
}
