package com.tom.common.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 19:37
 */
@Component
public class CommonStepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("CommonStepListener -> beforeStep : " + stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("CommonStepListener -> afterstep : " + stepExecution.getStepName());
        return stepExecution.getExitStatus();
    }
}
