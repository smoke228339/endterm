package controllers;

import controllers.interfaces.IProductController;
import entities.Product;
import repositories.interfaces.IProductRepository;

import java.util.List;

public class ProductController implements IProductController {
    private final IProductRepository productRepository;

    public ProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String addProduct(String name, int price, int quantity, int year) {
        Product product = new Product(name, price, quantity, year);
        boolean isAdded = productRepository.addProduct(product);
        if (isAdded) {
            return "Product added successfully!";
        }
        return "Failed to add product.";
    }

    @Override
    public Product getProductById(int id) {
        Product product = productRepository.getProductById(id);
        if (product == null) {
            System.out.println("Product with ID " + id + " not found.");
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public String updateProduct(int id, String name, int price, int quantity, int year) {
        Product product = productRepository.getProductById(id);
        if (product == null) {
            return "Product with ID " + id + " not found.";
        }
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setYear(year);

        boolean isUpdated = productRepository.updateProduct(product);
        if (isUpdated) {
            return "Product updated successfully!";
        }
        return "Failed to update product.";
    }

    @Override
    public String deleteProduct(int id) {
        boolean isDeleted = productRepository.deleteProduct(id);
        if (isDeleted) {
            return "Product deleted successfully!";
        }
        return "Failed to delete product.";
    }
}
