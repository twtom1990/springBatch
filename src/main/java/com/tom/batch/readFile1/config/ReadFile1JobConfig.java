package com.tom.batch.readFile1.config;

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
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 17:20
 */
@Configuration
public class ReadFile1JobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CommonJobListener commonJobListener;

    @Autowired
    private CommonStepListener commonStepListener;

    @Autowired
    private CommonChunkListener commonChunkListener;

    @Autowired
    private CommonItemReadListener commonItemReadListener;

    @Autowired
    private CommonItemProcessListener commonItemProcessListener;

    @Autowired
    private CommonItemWriteListener commonItemWriteListener;

    @Autowired
    private ReadFile1Processor readFile1Processor;

    @Bean
    public Job readFile1Job() {
        return jobBuilderFactory.get("readFile1Job")
                .incrementer(new RunIdIncrementer())
                .listener(commonJobListener)
                .start(readFile1Step()).build();
    }

    @Bean
    public Step readFile1Step() {
        return stepBuilderFactory.get("create").<ReadFile1Bean, ReadFile1Bean>chunk(10)
                .reader(readFile1Reader())
                .listener(commonItemReadListener)
                .processor(readFile1Processor)
                .listener(commonItemProcessListener)
                .writer(readFile1Writer())
                .listener(commonItemWriteListener)
                .listener(commonChunkListener)
                .build();
    }

    @Bean
    public FlatFileItemReader<ReadFile1Bean> readFile1Reader() {
        FlatFileItemReader<ReadFile1Bean> reader = new FlatFileItemReader<ReadFile1Bean>();
        reader.setResource(new ClassPathResource("file/FILE001"));
        reader.setLineMapper(new DefaultLineMapper<ReadFile1Bean>() {{
            setLineTokenizer(new DelimitedLineTokenizer("*+") {{
                setNames(new String[]{"name1", "name2", "name3","name4", "name5", "name6","name7", "name8", "name9"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<ReadFile1Bean>() {{
                setTargetType(ReadFile1Bean.class);
            }});
        }});
        return reader;
    }

//    @Bean
//    public UserMapItemProcessor processor(UserMapItemProcessor.ProcessStatus processStatus) {
//        return new UserMapItemProcessor(processStatus);
//    }

    @Bean
    public ItemWriter<ReadFile1Entity> readFile1Writer() {
        ItemWriter itemWriter = new ItemWriter() {
            @Override
            public void write(List list) throws Exception {
                System.out.println("fuck");
                System.out.println(list.toString());
            }
        };

        return itemWriter;
    }



}
