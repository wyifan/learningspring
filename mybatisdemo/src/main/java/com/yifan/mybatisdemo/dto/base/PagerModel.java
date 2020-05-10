package com.yifan.mybatisdemo.dto.base;

import java.util.List;

public class PagerModel<T extends BaseRowModel>  {
    private List<T> listModel;
    private long totalRecotrdCount;

    public List<T> getListModel() {
        return listModel;
    }

    public void setListModel(List<T> listModel) {
        this.listModel = listModel;
    }

    public long getTotalRecotrdCount() {
        return totalRecotrdCount;
    }

    public void setTotalRecotrdCount(long totalRecotrdCount) {
        this.totalRecotrdCount = totalRecotrdCount;
    }
}
