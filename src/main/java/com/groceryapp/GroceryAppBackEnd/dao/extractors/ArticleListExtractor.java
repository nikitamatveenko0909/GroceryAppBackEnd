package com.groceryapp.GroceryAppBackEnd.dao.extractors;

import com.groceryapp.GroceryAppBackEnd.dto.article.Article;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleListExtractor implements ResultSetExtractor<List<Article>> {
    @Override
    public List<Article> extractData(ResultSet rs) throws SQLException, DataAccessException{
        List<Article> articles = new ArrayList<>();
        System.out.println("16" + articles);
        while(rs.next()){
            Article article = new Article();
            article.setId(rs.getLong("id"));
            article.setName(rs.getString("name"));
            article.setPrice(rs.getDouble("price"));
            System.out.println("22" + article);
            articles.add(article);
        }
        System.out.println("24" + articles);
        return articles;
    }
}
