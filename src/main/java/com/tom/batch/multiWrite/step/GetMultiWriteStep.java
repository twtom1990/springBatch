package com.tom.batch.multiWrite.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.persistence.EntityManager;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-21
 * Time: 22:21
 */
@Configuration
public class GetMultiWriteStep {
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Qualifier("multiWriteTasklet")
    public Tasklet multiWriteTasklet;

//    @Autowired
//    @Qualifier("transactionManagerBatch")
//    public PlatformTransactionManager transactionManagerBatch;
//
//    @Autowired
//    @Qualifier("transactionManagerDocuments")
//    public PlatformTransactionManager transactionManagerDocuments;

    @Bean
    public Step multiWriteStep() {
        Step step =  stepBuilderFactory
                .get("getWriteStep")
                .tasklet(multiWriteTasklet)
//                .transactionManager(transactionManagerBatch)
//                .transactionManager(transactionManagerDocuments)
                .build();
        return step;
    }

}
