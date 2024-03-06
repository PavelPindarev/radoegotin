package com.example.hello;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("productBean")
@ApplicationScoped
public class ProductBean {
    private List<Product> products;

    public ProductBean() {
        this.products = new ArrayList<>();
        this.products.add(new Product("Minced Meat", "meatffgd...", 6.70));
        this.products.add(new Product("Rice", "white rice...", 1.65));
        this.products.add(new Product("Pasta", "italiano pasta...", 2.30));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
