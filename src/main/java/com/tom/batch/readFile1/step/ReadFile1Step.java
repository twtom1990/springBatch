//package com.tom.batch.readFile1.step;
//
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
///**
// * Created with Tang Wei
// * Description:
// * User: SEELE
// * Date: 2020-02-16
// * Time: 17:41
// */
//@Component
//public class ReadFile1Step {
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Step createStep(){
//        return stepBuilderFactory.get("create").<Employee, Employee>chunk(10)
//                .reader(reader)
//                .listener(readerListener)
//                .processor(processor)
//                //.listener(processListener)
//                .writer(writer)
//                .listener(promotionListener())
//                .listener(chunkListener).build();
//
//    }
//}
