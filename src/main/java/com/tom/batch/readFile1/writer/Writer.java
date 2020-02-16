//package com.tom.batch.readFile1.writer;
//
//import com.explore.spring.springbatch.EmployeeConstants;
//import com.explore.spring.springbatch.model.Employee;
//import org.springframework.batch.core.StepExecution;
//import org.springframework.batch.core.annotation.BeforeStep;
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class Writer implements ItemWriter<Employee> {
//
//    private StepExecution stepExecution;
//
//    @Override
//    public void write(List<? extends Employee> list) throws Exception {
//
//        // add to batch report
//        addToBatchReport((List<Employee>) list);
//
//    }
//
//    private void addToBatchReport(List<Employee> group) {
//        ExecutionContext stepContext = this.stepExecution.getExecutionContext();
//
//        Object groupReport = stepContext.get(EmployeeConstants.group_report);
//
//        if (groupReport == null) {
//            groupReport = new ArrayList<List<Employee>>();
//        }
//        ((List<List<Employee>>) groupReport).add(group);
//
//        stepContext.put(EmployeeConstants.group_report, groupReport);
//    }
//
//    @BeforeStep
//    public void setStepExecution(StepExecution stepExecution) {
//        this.stepExecution = stepExecution;
//    }
//}
