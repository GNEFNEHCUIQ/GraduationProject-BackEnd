package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDao {
    List<Article> findAllArticle();

    List<Article> findArticle(String sort);

    void addArticle(String title, String sort, String content,int author);

    void delArticle(int article_id);

    Integer ifArticleExist(int article_id);

    List<Article> searchArticle(String title);

    Article findArticleById(int article_id);
}
