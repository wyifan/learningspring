package com.yifan.springbatch.config;

import com.yifan.springbatch.batch.item.Reader;
import com.yifan.springbatch.batch.item.process;
import com.yifan.springbatch.batch.item.writer;
import com.yifan.springbatch.model.Message;
import com.yifan.springbatch.model.User;
import com.yifan.springbatch.repository.UserRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<User> itemReader,
                   ItemProcessor<User, User> itemProcessor,
                   ItemWriter<User> itemWriter,
                   ItemProcessor<User, Message> msgProcessor,
                   ItemWriter<Message> msgWriter
    ) {
        Step step = stepBuilderFactory.get("ETL-file-load")
                .<User, User>chunk(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        Step msgStep = stepBuilderFactory.get("MSG-LOAD")
                .<User, Message>chunk(10)
                .reader(itemReader)
                .processor(msgProcessor)
                .writer(msgWriter)
                .build();

        return jobBuilderFactory.get("ETL-Job")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .next(msgStep)
                .build();
    }

    @Bean
    public FlatFileItemReader<User> fileItemReader(
//            @Value("${input}")Resource resource
    ) {
        FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("users.csv"));
//        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());

        return flatFileItemReader;
    }

    @Bean
    public LineMapper<User> lineMapper() {
        DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"id", "name", "dept", "salary"});

        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(User.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;

    }

    @Bean(name = "WriteStringToUser")
    public Job customJob(JobBuilderFactory jobBuilderFactory,
                         StepBuilderFactory stepBuilderFactory) {

        Step step = stepBuilderFactory.get("StepStringToUser")
                .<String,User>chunk(10)
                .reader(new Reader())
                .processor(new process())
                .writer(new writer(userRepository))
                .build();

        return jobBuilderFactory.get("WriteStringToUser")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

}
