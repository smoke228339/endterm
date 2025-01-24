package controllers.interfaces;

import entities.Product;

import java.util.List;

public interface IProductController {
    String addProduct(String name, int price, int quantity, int year);
    Product getProductById(int id);
    List<Product> getAllProducts();
    String updateProduct(int id, String name, int price, int quantity, int year);
    String deleteProduct(int id);
}
