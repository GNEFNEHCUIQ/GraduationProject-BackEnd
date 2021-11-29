package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Article;
import com.sise.makerSpace.domain.PageRequest;
import com.sise.makerSpace.domain.PageResult;

import java.util.List;

public interface ArticleService {
    List<Article> findAllArticle();

    List<Article> findLatestArticle();

    List<Article> findLatestArticle(String sort, int pageIndex, int pageSize);

    PageResult findAllArticleWithPage(PageRequest pageRequest);

    PageResult findArticle(String sort, PageRequest pageRequest);

    void addArticle(String title, String sort, String content,int author);
}
