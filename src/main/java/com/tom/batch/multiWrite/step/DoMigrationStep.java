//package com.tom.batch.multiWrite.step;
//
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created with Tang Wei
// * Description:
// * User: SEELE
// * Date: 2020-02-23
// * Time: 19:27
// */
//@Configuration
//public class DoMigrationStep {
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Bean(name="doMigrationSlaveStep")
//    public Step doMigrationSlaveStep(){
//        return stepBuilderFactory.get("doMigrationSlaveStep");
//    }
//}
