package com.yifan.mybatis.mapper;

import com.yifan.mybatis.domain.City;
import com.yifan.mybatis.domain.CityLess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


@Mapper
public interface CityMapper {

//    @Select("select id, name, state, country from city where state = #{state}")
    City findByState(@Param("state") String state);

//    @SelectProvider(type = SqlProviderAdapter.Class, method="select")
//    CityLess findCity(SelectStatementProvider selectStatementProvider);

}
