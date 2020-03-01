//package com.tom.batch.multiWrite.step;
//
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.partition.support.Partitioner;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created with Tang Wei
// * Description:
// * User: SEELE
// * Date: 2020-02-23
// * Time: 19:19
// */
//@Configuration
//public class MigrationStep {
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    @Qualifier("migrationPartitioner")
//    public Partitioner migrationPartitioner;
//
//    @Bean(name="migrationMasterStep")
//    public Step migrationMasterStep(){
//        return stepBuilderFactory.get("migrationMasterStep").partitioner(,migrationPartitioner)
//    }
//}
