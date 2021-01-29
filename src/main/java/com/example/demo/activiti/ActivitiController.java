//package com.example.demo.activiti;
//
//
//import org.activiti.engine.IdentityService;
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.TaskService;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.activiti.engine.task.Task;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/activiti")
//public class ActivitiController {
//
////    @Autowired
////    private ActivityService activityService;
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private IdentityService identityService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private RepositoryService repositoryService;
//
//    @RequestMapping("/initiationProcess")
//    public String initiationProcess(String ... str) {
//        //取得流程实例
//        Map<String, Object> map = new HashMap<>();
//        map.put("applier", str[0]);
//        map.put("team", str[1]);
//        map.put("hr", str[2]);
//        map.put("ceo", str[3]);
//        ProcessInstance pi = this.runtimeService.startProcessInstanceByKey("myProcess", map);
//        System.out.println("流程实例id=" + pi.getId());
//        System.out.println("流程定义id=" + pi.getProcessDefinitionId());
//        return "流程实例id=" + pi.getId() + "\n" + "流程定义id=" + pi.getProcessDefinitionId();
//
//    }
//
//    @RequestMapping("/queryTask")
//    public void queryTask (String name) {
//        List<Task> list = this.taskService.createTaskQuery().taskAssignee(name).list();
//        if(list!=null&&list.size()>0){
//            for(Task task:list){
//                System.out.println("任务的办理人："+task.getAssignee());
//                System.out.println("任务的id："+task.getId());
//                System.out.println("任务的名称："+task.getName());
//            }
//        }
//    }
////    user userrs users
//    @RequestMapping("/compileTask")
//    public void compileTask(String id) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        this.taskService.complete(id, map);
//    }
//
//}
