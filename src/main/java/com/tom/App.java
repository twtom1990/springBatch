package com.tom;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 16:56
 */
//@EnableBatchProcessing(modular=true)
@EnableBatchProcessing
@SpringBootApplication
@EnableRetry
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}


