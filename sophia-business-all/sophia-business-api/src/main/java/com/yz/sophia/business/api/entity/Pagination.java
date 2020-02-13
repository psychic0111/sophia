package com.yz.sophia.business.api.entity;

import com.yz.sophia.business.api.exception.BusinessException;


/**
 * 分页定义
 */
public class Pagination {

    public static final Integer MAX_PAGE_SIZE = 1000;

    private Integer pageNum;
    private Integer pageSize;
    private boolean count = true;


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum != null) {
            if (pageNum <= 0) {
                throw new BusinessException("分页页码必须大于0");
            }
        }
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null) {
            if (pageSize > MAX_PAGE_SIZE) {
                pageSize = MAX_PAGE_SIZE;
            } else if (pageSize <= 0) {
                throw new BusinessException("分页大小必须大于0");
            }
        }
        this.pageSize = pageSize;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public boolean isPageable(){
        return this.pageNum != null && this.pageNum > 0 && this.pageSize != null && this.pageSize > 0;
    }
}
