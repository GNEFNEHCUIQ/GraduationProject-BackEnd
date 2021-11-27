package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.ArticleDao;
import com.sise.makerSpace.domain.Article;
import com.sise.makerSpace.service.ArticleService;
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
}
