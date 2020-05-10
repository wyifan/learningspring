package com.yifan.mybatisdemo.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;

public class CommonMybatisItemWriter<T> extends MyBatisBatchItemWriter<T> {

    public  CommonMybatisItemWriter(SqlSessionFactory sqlSessionFactory, String name) {
        setSqlSessionFactory(sqlSessionFactory);
        setStatementId("com.yifan.mybatisdemo.dao.mapper." + name + "Mapper.updateByPrimaryKeySelective");
        setAssertUpdates(false);
    }
}
