package com.groceryapp.GroceryAppBackEnd.controller.article;

import com.groceryapp.GroceryAppBackEnd.dto.article.Article;
import com.groceryapp.GroceryAppBackEnd.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService){this.articleService = articleService;}

    @GetMapping("/articles")
    public ResponseEntity<Object> getArticles(){
        List<Article> articles = articleService.getArticles();
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK);
        response.put("result", articles);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
