package com.tom.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-03-01
 * Time: 14:41
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class batchController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    private Job readFile1Job;

    @Autowired
    private Job multiWriteJob;

    @GetMapping("/readFile1Job/{type}")
    public String readFileController(@PathVariable(name = "type") String type , @RequestParam(name = "date") String date) {

        try {
            long runtime = System.currentTimeMillis();
            JobParametersBuilder jobParameters = new JobParametersBuilder();
            jobParameters.addString("date", date);
            JobExecution jobExecution = jobLauncher.run(readFile1Job, jobParameters.toJobParameters());
            return "Job run at [" + new Date(runtime) + "]. readFile1Job. status = " + jobExecution.getStatus();
        } catch (Exception e) {
            log.error("Error : ", e);
            return "could not run job" + e.getMessage();
        }
    }

    @GetMapping("/multiWrite/{type}")
    public String multiController(@PathVariable(name = "type") String type , @RequestParam(name = "date") String date) {

        try {
            long runtime = System.currentTimeMillis();
            JobParametersBuilder jobParameters = new JobParametersBuilder();
            jobParameters.addString("date", date);
            JobExecution jobExecution = jobLauncher.run(multiWriteJob, jobParameters.toJobParameters());
            return "Job run at [" + new Date(runtime) + "]. multiWrite. status = " + jobExecution.getStatus() ;
        } catch (Exception e) {
            log.error("Error : ", e);
            return "could not run job" + e.getMessage();
        }
    }

    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
