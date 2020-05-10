package com.yifan.mybatisdemo.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

public class CommonMybatisItemReader<T> extends MyBatisPagingItemReader<T> {

    public CommonMybatisItemReader(SqlSessionFactory sqlSessionFactory, String name) {
        setSqlSessionFactory(sqlSessionFactory);
        setQueryId("com.yifan.mybatisdemo.dao.mapper." + name + "Mapper.listJob");
        setPageSize(100);
    }
}
