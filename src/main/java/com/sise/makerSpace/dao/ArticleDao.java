package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDao {
    List<Article> findAllArticle();

    List<Article> findLatestArticle();

    List<Article> findLatestArticle(String sort,int pageIndex,int pageSize);
}
