package com.yifan.mybatisdemo.service.impl.base;


import com.yifan.mybatisdemo.dao.entity.base.BaseEntity;
import com.yifan.mybatisdemo.dao.mapper.base.BaseMapper;
import com.yifan.mybatisdemo.dto.base.BaseModel;
import com.yifan.mybatisdemo.dto.base.BaseRowModel;
import com.yifan.mybatisdemo.service.base.BaseService;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public abstract class BaseServiceImpl<T extends BaseEntity,
        ListModel extends BaseRowModel, FilterModel extends BaseModel,
        SelectModel extends BaseRowModel, AddModel extends BaseModel, ModifyModel extends BaseRowModel>
        implements BaseService<T, ListModel, FilterModel,
        SelectModel, AddModel, ModifyModel> {
    public abstract BaseMapper<T, ListModel, FilterModel, SelectModel> getMapper();

    // public abstract BaseMapper<DataAttachment, BaseRowModel, BaseModel, BaseRowModel> getAttachmentMapper();

    public abstract T getInsertEntity(AddModel addModel);

    public abstract T getUpdateEntity(ModifyModel modifyModel);

    @Override
    public List<T> getListByFilter(FilterModel filterModel) {
        return getMapper().selectByExample(filterModel);
    }

    @Override
    public List<ListModel> getModelListByFilter(FilterModel filterModel) {
        return getMapper().selectModelListByFilter(filterModel);
    }

    @Override
    public String add(AddModel addModel) {
//        HttpSession session = request.getSession();
//        String userName = (String) session.getAttribute(KeyNames.SESSION_ATTRIBUTE_NAME);
        T entity = getInsertEntity(addModel);
        entity.setId(UUID.randomUUID().toString());
        entity.setInsertTime(new Date());
//        entity.setInsertBy(userName);
        getMapper().insert(entity);
        return entity.getId();
    }

    @Override
    public T findById(String id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public SelectModel getModelById(String id) {
        return getMapper().selectModelById(id);
    }

    @Override
    public void modify(ModifyModel modifyModel) {
//        HttpSession session = request.getSession();
//        String userName = (String) session.getAttribute(KeyNames.SESSION_ATTRIBUTE_NAME);
        T entity = getUpdateEntity(modifyModel);
        entity.setUpdateTime(new Date());
//        entity.setUpdateBy(userName);
        getMapper().updateByPrimaryKey(entity);
    }

    @Transactional
    @Override
    public void remove(String ID) {
        T deleteEntity = getMapper().selectByPrimaryKey(ID);
        if (deleteEntity != null) {
//            HttpSession session = request.getSession();
//            String userName = (String) session.getAttribute(KeyNames.SESSION_ATTRIBUTE_NAME);
//            DataRecycle dataRecycle = new DataRecycle();
//            dataRecycle.setId(UUID.randomUUID().toString());
//            dataRecycle.setTableName(deleteEntity.getClass().getSimpleName());
//            dataRecycle.setRowId(deleteEntity.getId());
//            byte[] bytes = org.apache.commons.lang3.SerializationUtils.serialize(deleteEntity);
//            String jsonStr = Base64.getEncoder().encodeToString(bytes);
//            dataRecycle.setRowData(jsonStr);
//            dataRecycle.setDeleteBatchCode(deleteEntity.getId().toString());
//            dataRecycle.setInsertTime(new Date());
//            dataRecycle.setInsertBy(userName);
//            getRecycleMapper().insert(dataRecycle);
            getMapper().deleteByPrimaryKey(ID);
        }
    }

    @Transactional
    @Override
    public void deleteByFilter(FilterModel filterModel) {
        List<T> deleteList = getMapper().selectByExample(filterModel);
//        HttpSession session = request.getSession();
//        String userName = (String) session.getAttribute(KeyNames.SESSION_ATTRIBUTE_NAME);
        for (T deleteEntity : deleteList
        ) {
//            DataRecycle dataRecycle = new DataRecycle();
//            dataRecycle.setId(UUID.randomUUID().toString());
//            dataRecycle.setTableName(deleteEntity.getClass().getSimpleName());
//            dataRecycle.setRowId(deleteEntity.getId());
//            byte[] bytes = org.apache.commons.lang3.SerializationUtils.serialize(deleteEntity);
//            String jsonStr = Base64.getEncoder().encodeToString(bytes);
//            dataRecycle.setRowData(jsonStr);
//            dataRecycle.setDeleteBatchCode(deleteEntity.getId().toString());
//            dataRecycle.setInsertTime(new Date());
//            dataRecycle.setInsertBy(userName);
//            getRecycleMapper().insert(dataRecycle);
            getMapper().deleteByPrimaryKey(deleteEntity.getId());
        }
    }

//    public PageResp<ListModel> queryPage(Integer page, Integer size, FilterModel filterModel) {
//        PageHelper.startPage(page, size);
//        // 如果需要查询blob字段，请使用 selectByExampleWithBlobsWithPageResp 方法
//        return getMapper().selectPageByExample(filterModel);
//    }
//
//    public PageResp<T> query(Integer page, Integer size, FilterModel filterModel) {
//        PageHelper.startPage(page, size);
//        // 如果需要查询blob字段，请使用 selectByExampleWithBlobsWithPageResp 方法
//        return getMapper().selectByExampleWithPageResp(filterModel);
//    }
}
