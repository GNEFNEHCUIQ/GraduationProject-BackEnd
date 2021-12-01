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

    @Override
    public PageResult findArticle(String sort,PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Article> findArticle=articleDao.findArticle(sort);
        PageInfo<Article> articlePageInfo=new PageInfo<>(findArticle);
        return PageUtils.getPageResult(pageRequest,articlePageInfo);
    }

    @Override
    public void addArticle(String title, String sort, String content,int author) {
         articleDao.addArticle(title,sort,content,author);
    }

    @Override
    public void delArticle(int article_id) {
        articleDao.delArticle(article_id);
    }

    @Override
    public boolean ifArticleExist(int article_id) {
        if (articleDao.ifArticleExist(article_id)==1)
        return true;
        else
            return false;
    }


}
