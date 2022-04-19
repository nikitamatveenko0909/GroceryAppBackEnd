package com.groceryapp.GroceryAppBackEnd.dto.article;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Article {

    public Article(long id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Article(String name, Double price){
        this.name = name;
        this.price = price;
    }

    private long id;
    @NotNull
    private String name;
    @NotNull
    private Double price;
}
