package com.tom.batch.multiWrite.tasklet;

import com.tom.batch.multiWrite.entity.batch.Entity1;
import com.tom.batch.multiWrite.entity.documents.Title;
import com.tom.batch.multiWrite.repository.batch.Entity1Repository;
import com.tom.batch.multiWrite.repository.documents.TitleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-21
 * Time: 22:21
 */
@Component("multiWriteTasklet")
@Slf4j
//@Transactional
public class MultiWriteTasklet implements Tasklet {
    @Autowired
    private Entity1Repository entity1Repository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource datasource;

//    @Autowired
//    @Qualifier("dataSourceBatch")
//    private DataSource dataSourceBatch;
//
//    @Autowired
//    @Qualifier("dataSourceDocuments")
//    private DataSource dataSourceDocuments;



    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        log.info("entity1-----start");
        Entity1 e1 = new Entity1();
        e1.setId(UUID.randomUUID().toString());
        e1.setName("1");
        entity1Repository.save(e1);
        e1.setId(UUID.randomUUID().toString());
        log.info(String.valueOf(entity1Repository.count()));
        log.info(entity1Repository.findAll().toString());



        //------------------------------

        log.info("title-----start");
        log.info(String.valueOf(titleRepository.findAll()));
        Title title = new Title();
        title.setTitleId(UUID.randomUUID().toString());
        title.setTitleName("888");
        titleRepository.save(title);
        log.info(titleRepository.findAll().toString());

        return RepeatStatus.FINISHED;
    }
}
