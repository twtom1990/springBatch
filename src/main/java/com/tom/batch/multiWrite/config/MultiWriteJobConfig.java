package com.tom.batch.multiWrite.config;

import com.tom.batch.readFile1.processor.ReadFile1Processor;
import com.tom.bean.ReadFile1Bean;
import com.tom.common.listener.*;
import com.tom.entity.ReadFile1Entity;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.batch.api.listener.JobListener;
import java.util.List;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 17:20
 */
@Configuration
public class MultiWriteJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    @Qualifier("multiWriteStep")
    private Step multiWriteStep;

    @Autowired
    @Qualifier("commonJobListener")
    private JobExecutionListener commonJobListener;

    @Bean
    public Job multiWriteJob() {
        return jobBuilderFactory.get("multiWriteJob")
                .incrementer(new RunIdIncrementer())
                .listener(commonJobListener)
                .start(multiWriteStep).build();
    }
}
