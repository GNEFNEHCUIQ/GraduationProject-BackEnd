package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.PageRequest;
import com.sise.makerSpace.domain.PageResult;

public interface PageService {
    PageResult findPage(PageRequest pageRequest);
}
