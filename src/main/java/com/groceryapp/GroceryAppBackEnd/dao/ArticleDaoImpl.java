package com.groceryapp.GroceryAppBackEnd.dao;

import com.groceryapp.GroceryAppBackEnd.dao.extractors.ArticleListExtractor;
import com.groceryapp.GroceryAppBackEnd.dao.interfaces.ArticleDao;
import com.groceryapp.GroceryAppBackEnd.dto.article.Article;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("postgres-articles")
public class ArticleDaoImpl implements ArticleDao {

    private JdbcTemplate jdbcTemplate;

    public ArticleDaoImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
    @Override
    public int[] insertArticle(long id, String name, Double price){
        String sql = "INSERT INTO articles (id, name, price) " +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.batchUpdate(
                sql,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, id);
                        ps.setString(2, name);
                        ps.setDouble(3, price);
                    }

                    @Override
                    public int getBatchSize() {
                        return 0;
                    }
                }
        );
    }
    public List<Article> getArticles(){
        String sql = "SELECT * FROM articles";
        System.out.println("43" + jdbcTemplate.query(sql, new ArticleListExtractor()));
        return jdbcTemplate.query(sql, new ArticleListExtractor());
    }
}
