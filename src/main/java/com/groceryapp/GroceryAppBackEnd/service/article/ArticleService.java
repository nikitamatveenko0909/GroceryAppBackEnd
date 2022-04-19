package com.groceryapp.GroceryAppBackEnd.service.article;

import com.groceryapp.GroceryAppBackEnd.dao.interfaces.ArticleDao;
import com.groceryapp.GroceryAppBackEnd.dto.article.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service
public class ArticleService {
    private final ArticleDao articleDao;

    public ArticleService(@Qualifier("postgres-articles") ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    public List<Article> getArticles(){
        return articleDao.getArticles();
    }
}
