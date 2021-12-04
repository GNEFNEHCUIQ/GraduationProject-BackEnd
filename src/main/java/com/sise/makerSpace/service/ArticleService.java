package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Article;
import com.sise.makerSpace.domain.PageRequest;
import com.sise.makerSpace.domain.PageResult;

import java.util.List;

public interface ArticleService {

    PageResult findAllArticleWithPage(PageRequest pageRequest);

    PageResult findArticle(String sort, PageRequest pageRequest);

    void addArticle(String title, String sort, String content,int author);

    void delArticle(int article_id);

    boolean ifArticleExist(int article_id);
}
