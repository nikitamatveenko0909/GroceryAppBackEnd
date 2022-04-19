package com.groceryapp.GroceryAppBackEnd.dao.interfaces;

import com.groceryapp.GroceryAppBackEnd.dto.article.Article;

import java.util.List;

public interface ArticleDao {
    int[] insertArticle(long id, String name, Double price);
    List<Article> getArticles();
}
