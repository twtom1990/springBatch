package com.tom.config;


import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-22
 * Time: 19:07
 */
@Configuration
@EnableTransactionManagement
//@DependsOn("transactionManager")
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactoryBatch",//配置连接工厂 entityManagerFactory
//        transactionManagerRef = "transactionManager", //配置 事物管理器  transactionManager
//        basePackages = "com.tom.batch.multiWrite.repository.batch"//设置dao（repo）所在位置
//)
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryBatch",//配置连接工厂 entityManagerFactory
        transactionManagerRef = "transactionManagerBatch", //配置 事物管理器  transactionManager
        basePackages = "com.tom.batch.multiWrite.repository.batch"//设置dao（repo）所在位置
)
@Slf4j
public class BatchDataSourceConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("dataSourceBatch")
    private DataSource dataSourceBatch;


    @Primary
    @Bean(name = "entityManagerBatch")
    public EntityManager entityManagerBatch(EntityManagerFactoryBuilder builder) {
        EntityManager entityManager = entityManagerFactoryBatch(builder).getObject().createEntityManager();
        return entityManager;
    }

    /**
     * @param builder
     * @return
     */

    @Bean(name = "entityManagerFactoryBatch")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBatch(EntityManagerFactoryBuilder builder) {
        return builder
                //设置数据源
                .dataSource(dataSourceBatch)
                //设置数据源属性
                .properties(getVendorProperties(dataSourceBatch))
                //设置实体类所在位置.扫描所有带有 @Entity 注解的类
                .packages("com.tom.batch.multiWrite.entity.batch")
                // Spring会将EntityManagerFactory注入到Repository之中.有了 EntityManagerFactory之后,
                // Repository就能用它来创建 EntityManager 了,然后Entity就可以针对数据库执行操作
                .persistenceUnit("batchPersistenceUnit")
                .build();

    }

    private Map<String, String> getVendorProperties(DataSource dataSource)  {
        Map<String, String> properties =  jpaProperties.getProperties();
//        properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
//        properties.put("javax.persistence.transactionType", "JTA");
        log.info("batchDataSourceConfig---Start");
        log.info(jpaProperties.getProperties().toString());
        log.info("batchDataSourceConfig---End");
        return properties;
    }

    /**
     * 事物管理器
     *
     * @param builder
     * @return
     */

    @Bean(name = "transactionManagerBatch")
    @Primary
    PlatformTransactionManager transactionManagerBatch(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBatch(builder).getObject());
    }
}
