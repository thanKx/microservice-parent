package org.xieq.bpm.controller;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author xieq
 * @date 2023/7/7 15:40
 */
@RestController
@RequestMapping("/vacate")
@Slf4j
public class VacateController {

    @Autowired
    private ProcessEngine processEngine;

    public static final String vacateProcessInstanceId = "Process_vacate";

    @GetMapping(path = "/start")
    public String startProcess(String businessKey) {
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(vacateProcessInstanceId, businessKey);
        Task task = processEngine.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        processEngine.getTaskService().setAssignee(task.getId(),  "wangl");
        log.info("task.getName:{}, \n processInstance.getId:{},\n processInstance.getProcessInstanceId: {},\n task.getProcessInstanceId: {}",
                task.getName(), processInstance.getId(), processInstance.getProcessInstanceId(), task.getProcessInstanceId());
        return processInstance.getId();
    }

    @GetMapping("/list")
    public void list(String user) {
        processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee(user)
                .list()
                .forEach(task -> log.info("任务名称：{}, 任务id:{}, 任务实例Id:{}", task.getName(), task.getId(), task.getProcessInstanceId()));
    }


    @GetMapping("/flows")
    public void flows(String taskId) {

    }

    @GetMapping("/complete")
    public String complete(String taskId, String flowId) {
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("flowId", flowId);
        variables.put("agree", false);
        processEngine.getTaskService().complete(taskId, variables);
        processEngine.getTaskService().setOwner(taskId, "wangl");
        return "succeed";
    }

}
