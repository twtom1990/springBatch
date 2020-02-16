//package com.tom.batch.readFile1.reader;
//
//import com.explore.spring.springbatch.model.Employee;
//import com.tom.bean.ReadFile1Bean;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.NonTransientResourceException;
//import org.springframework.batch.item.ParseException;
//import org.springframework.batch.item.UnexpectedInputException;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@StepScope
//@Component
//public class Reader extends FlatFileItemReader<ReadFile1Bean> {
//
//    private int count = 20;
//    private String dept;
//
//    @Override
//    public Employee read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        if (count != 0) {
//            count--;
//            return new Employee(count, "first" + count, "last" + count, getDept());
//        } else {
//            return null;
//        }
//    }
//
//    @Value("#{jobParameters['department']}")
//    public void setRuntime(final String dept) {
//        this.dept = dept;
//    }
//
//    public String getDept() {
//        return dept;
//    }
//
//}
