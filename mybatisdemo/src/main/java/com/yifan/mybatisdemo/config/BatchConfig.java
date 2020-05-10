package com.yifan.mybatisdemo.config;

import com.yifan.mybatisdemo.common.CommonMybatisItemReader;
import com.yifan.mybatisdemo.common.CommonMybatisItemWriter;
import com.yifan.mybatisdemo.dao.entity.base.Messages;
import com.yifan.mybatisdemo.service.base.MessagesService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.Date;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    //    @Autowired
//    public DataSource dataSource;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        return factoryBean.getObject();
//    }
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private static final Date date = new Date();

    @Autowired
    private MessagesService messagesService;

    @Bean(name = "SendSMSMailJob")
    public Job customJob(JobBuilderFactory jobBuilderFactory,
                         StepBuilderFactory stepBuilderFactory
    ) {

        Step step = stepBuilderFactory.get("SendMsgStep")
                .<Messages, Messages>chunk(10)
//                .reader(new MessageReader(messagesService))
                .reader(messagesCommonMybatisItemReader())
                .processor(new MessageProcessor())
                .writer(commonMybatisItemWriter())
//                .writer(new MessageWriter(messagesService))
                .allowStartIfComplete(true)
                .build();

        return jobBuilderFactory.get("WriteStringToUser")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<Messages> messagesCommonMybatisItemReader() {
        return new CommonMybatisItemReader(sqlSessionFactory, Messages.class.getSimpleName());
    }

    @Bean
    @StepScope
    public CommonMybatisItemWriter<Messages> commonMybatisItemWriter() {
        return new CommonMybatisItemWriter<Messages>(sqlSessionFactory, Messages.class.getSimpleName());
    }

}
