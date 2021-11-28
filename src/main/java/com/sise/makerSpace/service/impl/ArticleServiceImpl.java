package com.sise.makerSpace.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.makerSpace.dao.ArticleDao;
import com.sise.makerSpace.domain.Article;
import com.sise.makerSpace.domain.PageRequest;
import com.sise.makerSpace.domain.PageResult;
import com.sise.makerSpace.service.ArticleService;
import com.sise.makerSpace.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> findAllArticle() {
        return articleDao.findAllArticle();
    }

    @Override
    public List<Article> findLatestArticle() {
        return articleDao.findLatestArticle();
    }

    @Override
    public List<Article> findLatestArticle(String sort, int pageIndex, int pageSize) {
        return articleDao.findLatestArticle(sort,pageIndex,pageSize);
    }

    @Override
    public PageResult findAllArticleWithPage(PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Article> allArticleWithPage=articleDao.findAllArticle();
        PageInfo<Article> articlePageInfo=new PageInfo<>(allArticleWithPage);
        return PageUtils.getPageResult(pageRequest,articlePageInfo);
    }

}
