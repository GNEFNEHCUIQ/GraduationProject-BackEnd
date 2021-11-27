package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDao {
    List<Article> findAllArticle();
}
