//package com.example.demo.activiti;
//
//import org.activiti.engine.ProcessEngine;
//import org.activiti.engine.ProcessEngineConfiguration;
//import org.activiti.engine.TaskService;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.activiti.engine.task.Task;
//import org.activiti.engine.task.TaskQuery;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
///* user userrs users */
//public class WorkFlowDemo {
//    private ProcessEngine processEngine;
//    public static void main(String[] args) {
//
//
//
//    }
//
//    public void createActivitiEngine() {
//        ProcessEngineConfiguration engineConfiguration=ProcessEngineConfiguration.
//                createStandaloneProcessEngineConfiguration();
//        //设置数据库连接属性
//        engineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
//        engineConfiguration.setJdbcUrl("jdbc:mysql://chxt.club:3306/test?createDatabaseIfNotExist=true"
//                + "&useUnicode=true&characterEncoding=utf8");
//        engineConfiguration.setJdbcUsername("root");
//        engineConfiguration.setJdbcPassword("123456");
//        engineConfiguration.setDatabaseSchemaUpdate("true");
//        this.processEngine = engineConfiguration.buildProcessEngine();
//    }
//
//    public void starProcess() {
//        //取得流程实例
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user", "gxj");
//        ProcessInstance pi = this.processEngine.getRuntimeService().startProcessInstanceByKey("leave", map);
//        System.out.println("流程实例id=" + pi.getId());
//        System.out.println("流程定义id=" + pi.getProcessDefinitionId());
//
//    }
//
//    // 查询任务
//    public void queryTask() {
//        List<Task> list = this.processEngine.getTaskService().createTaskQuery().taskAssignee("chxt").list();
//        if(list!=null&&list.size()>0){
//            for(Task task:list){
//                System.out.println("任务的办理人："+task.getAssignee());
//                System.out.println("任务的id："+task.getId());
//                System.out.println("任务的名称："+task.getName());
//            }
//        }
//    }
//
//    public void compileTask() {
//        String taskId = "";
//        processEngine.getTaskService().complete(taskId);
//    }
//}
