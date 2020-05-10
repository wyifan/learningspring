package com.yifan.mybatisdemo.service.base;


import com.yifan.mybatisdemo.dao.entity.base.BaseEntity;
import com.yifan.mybatisdemo.dto.base.BaseModel;
import com.yifan.mybatisdemo.dto.base.BaseRowModel;

import java.util.List;

public interface BaseService<T extends BaseEntity,
        ListModel extends BaseRowModel,
        FilterModel extends BaseModel,
        SelectModel extends BaseRowModel,
        AddModel extends BaseModel,
        ModifyModel extends BaseRowModel> {
    List<T> getListByFilter(FilterModel filterModel);

    List<ListModel> getModelListByFilter(FilterModel filterModel);

    String add(AddModel addModel);

    T findById(String id);

    SelectModel getModelById(String id);

    void modify(ModifyModel modifyModel);

    void deleteByFilter(FilterModel filterModel);

    void remove(String ID);

//    PageResp<T> query(Integer page, Integer size, FilterModel filterModel);
//
//    PageResp<ListModel> queryPage(Integer page, Integer size, FilterModel filterModel);
}
