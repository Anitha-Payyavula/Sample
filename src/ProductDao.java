package com.anitha.demorest;

import java.util.ArrayList;
import java.util.List;
 
public class ProductDao {
    private static ProductDao instance;
    private static List<Product> data = new ArrayList<>();
     
    static {
        data.add(new Product(1, "iPhone X", 999));
        data.add(new Product(2, "XBOX 360", 329));     
    }
     
    private ProductDao() {
         
    }
     
    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
         
        return instance;               
    }
     
    public List<Product> listAll() {
        return new ArrayList<Product>(data);
    }
     
    public int add(Product product) {
        int newId = data.size() + 1;
        product.setId(newId);
        data.add(product);
         
        return newId;
    }
     
    public Product get(int id) {
        Product productToFind = new Product(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }
     
    public boolean delete(int id) {
        Product productToFind = new Product(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }
         
        return false;
    }
     
    public boolean update(Product product) {
        int index = data.indexOf(product);
        if (index >= 0) {
            data.set(index, product);
            return true;
        }
        return false;
    }
}