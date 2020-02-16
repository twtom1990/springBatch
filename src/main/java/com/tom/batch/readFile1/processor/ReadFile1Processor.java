package com.tom.batch.readFile1.processor;

import com.tom.bean.ReadFile1Bean;
import com.tom.entity.ReadFile1Entity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ReadFile1Processor implements ItemProcessor<ReadFile1Bean, ReadFile1Entity> {

    @Override
    public ReadFile1Entity process(ReadFile1Bean bean) throws Exception {
        ReadFile1Entity entity = new ReadFile1Entity();
        BeanUtils.copyProperties(bean, entity);
        System.out.println(entity.toString());
        return entity;
    }
}
