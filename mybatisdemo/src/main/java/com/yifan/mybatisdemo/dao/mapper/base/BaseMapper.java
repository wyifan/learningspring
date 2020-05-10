package com.yifan.mybatisdemo.dao.mapper.base;


import com.yifan.mybatisdemo.dao.entity.base.BaseEntity;
import com.yifan.mybatisdemo.dto.base.BaseModel;
import com.yifan.mybatisdemo.dto.base.BaseRowModel;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseMapper <T extends BaseEntity,ListModel extends BaseRowModel,
        FilterModel extends BaseModel, SelectModel extends BaseRowModel>{

    List<ListModel> selectModelListByFilter(FilterModel filterModel);

    SelectModel selectModelById(String id);

    long countByExample(FilterModel example);


    int deleteByExample(FilterModel example);


    int deleteByPrimaryKey(String id);


    int insert(T record);


    int insertSelective(T record);


    List<T> selectByExampleWithRowbounds(FilterModel example, RowBounds rowBounds);


    List<T> selectByExample(FilterModel example);


    T selectByPrimaryKey(String id);


    int updateByExample(@Param("record") T record, @Param("example") FilterModel example);


    int updateByPrimaryKeySelective(T record);


    int updateByPrimaryKey(T record);


//    default PageResp<ListModel> selectPageByExample(FilterModel example) {
//        PageInfo<ListModel> pageInfo = PageInfo.of(selectModelListByFilter(example));
//        PageResp<ListModel> pageResp = new PageResp<>();
//        pageResp.setCurrentPage(pageInfo.getPageNum());
//        pageResp.setDatas(pageInfo.getList());
//        pageResp.setPageSize(pageInfo.getSize());
//        pageResp.setTotalCount(pageInfo.getTotal());
//        pageResp.setTotalPages(pageInfo.getPages());
//        pageResp.setStartIndex(pageInfo.getStartRow());
//        return pageResp;
//    }
//    default PageResp<T> selectByExampleWithPageResp(FilterModel example) {
//        PageInfo<T> pageInfo = PageInfo.of(selectByExample(example));
//        PageResp<T> pageResp = new PageResp<>();
//        pageResp.setCurrentPage(pageInfo.getPageNum());
//        pageResp.setDatas(pageInfo.getList());
//        pageResp.setPageSize(pageInfo.getSize());
//        pageResp.setTotalCount(pageInfo.getTotal());
//        pageResp.setTotalPages(pageInfo.getPages());
//        pageResp.setStartIndex(pageInfo.getStartRow());
//        return pageResp;
//    }
}
