package com.yifan.mybatisdemo.dto.base;

public class QueryModel<T extends BaseModel> {
    private T filterModel;
    private int pageSize;
    private int pageIndex;
    private String orderBy;



    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        pageIndex = pageIndex;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        orderBy = orderBy;
    }

    public T getFilterModel() {
        return filterModel;
    }

    public void setFilterModel(T filterModel) {
        filterModel = filterModel;
    }
}
