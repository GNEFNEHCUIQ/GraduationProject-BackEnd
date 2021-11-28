package com.sise.makerSpace.utils;

import com.github.pagehelper.PageInfo;
import com.sise.makerSpace.domain.PageRequest;
import com.sise.makerSpace.domain.PageResult;

public class PageUtils {
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
