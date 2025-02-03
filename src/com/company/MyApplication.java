package com.company;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import controllers.interfaces.IProductController;
import entities.Product;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MyApplication {
    private final IProductController controller;
    private final Scanner scanner;

    public MyApplication(IProductController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.println();
            System.out.println("Welcome to Product Management Application");
            System.out.println("1. Add product");
            System.out.println("2. Get product by ID");
            System.out.println("3. Get all products");
            System.out.println("4. Update product");
            System.out.println("5. Delete product");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            int option = this.scanner.nextInt();
            if (option == 0) {
                System.out.println("Thank you for using the application!");
                return;
            }

            try {
                switch (option) {
                    case 1:
                        this.addProduct();
                        break;
                    case 2:
                        this.getProductById();
                        break;
                    case 3:
                        this.getAllProducts();
                        break;
                    case 4:
                        this.updateProduct();
                        break;
                    case 5:
                        this.deleteProduct();
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addProduct() {
        System.out.println("Enter product name:");
        this.scanner.nextLine();
        String name = this.scanner.nextLine();
        System.out.println("Enter product price:");
        int price = this.scanner.nextInt();
        System.out.println("Enter product quantity:");
        int quantity = this.scanner.nextInt();
        System.out.println("Enter product year:");
        int year = this.scanner.nextInt();
        String result = this.controller.addProduct(name, price, quantity, year);
        System.out.println(result);
    }

    private void getProductById() {
        System.out.println("Enter product ID:");
        int id = this.scanner.nextInt();
        Product product = this.controller.getProductById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }

    }

    private void getAllProducts() {
        List var10000 = this.controller.getAllProducts();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }

    private void updateProduct() {
        System.out.println("Enter product ID to update:");
        int id = this.scanner.nextInt();
        System.out.println("Enter new product name:");
        String name = this.scanner.next();
        System.out.println("Enter new product price:");
        int price = this.scanner.nextInt();
        System.out.println("Enter new product quantity:");
        int quantity = this.scanner.nextInt();
        System.out.println("Enter new product year:");
        int year = this.scanner.nextInt();
        String result = this.controller.updateProduct(id, name, price, quantity, year);
        System.out.println(result);
    }

    private void deleteProduct() {
        System.out.println("Enter product ID to delete:");
        int id = this.scanner.nextInt();
        String result = this.controller.deleteProduct(id);
        System.out.println(result);
    }
}
