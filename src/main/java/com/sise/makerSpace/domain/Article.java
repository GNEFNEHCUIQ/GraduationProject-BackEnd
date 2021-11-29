package com.sise.makerSpace.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Article {
    private int articleId;
    private String sort;
    private String title;
    private String content;
    private String author;
    private String creationTime;

}
