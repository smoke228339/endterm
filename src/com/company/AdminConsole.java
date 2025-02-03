package com.company;

import controllers.interfaces.IProductController;
import repositories.interfaces.IOrderRepository;
import repositories.interfaces.IProductRepository;
import repositories.UserRepository;
import entities.OrderItemDetails;
import entities.Product;
import java.util.List;
import java.util.Scanner;

public class AdminConsole {
    private final IProductController productController;
    private final IOrderRepository orderRepository;  // Репозиторий для заказов
    private final Scanner scanner;


    public AdminConsole(IProductController productController, IOrderRepository orderRepository) {
        this.productController = productController;
        this.orderRepository = orderRepository;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to Admin Console");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. View all products");
            System.out.println("5. View order details");
            System.out.println("6. View expensive products (price > 1000)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    viewOrderDetails();  // Новый пункт меню для информации о заказах
                    break;
                case 6:
                    viewExpensiveProducts();
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter product price: ");
        int price = scanner.nextInt();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter product year: ");
        int year = scanner.nextInt();

        String result = productController.addProduct(name, price, quantity, year);
        System.out.println(result);
    }

    private void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        System.out.print("Enter new product name: ");
        String name = scanner.next();
        System.out.print("Enter new product price: ");
        int price = scanner.nextInt();
        System.out.print("Enter new product quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter new product year: ");
        int year = scanner.nextInt();

        String result = productController.updateProduct(id, name, price, quantity, year);
        System.out.println(result);
    }

    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        String result = productController.deleteProduct(id);
        System.out.println(result);
    }

    private void viewAllProducts() {
        List<Product> products = productController.getAllProducts();
        products.forEach(System.out::println);
    }

    private void viewOrderDetails() {
        System.out.print("Enter order ID: ");
        int orderId = scanner.nextInt();

        List<OrderItemDetails> orderDetails = orderRepository.getOrderDetails(orderId);
        if (orderDetails.isEmpty()) {
            System.out.println("Order not found.");
        } else {
            orderDetails.forEach(orderItem -> {
                System.out.println(orderItem);
                System.out.println("---------------------------");
            });
        }
    }
    private void viewExpensiveProducts() {
        List<Product> products = productController.getExpensiveProducts();
        if (products.isEmpty()) {
            System.out.println("No expensive products found.");
        } else {
            products.forEach(System.out::println);
        }
    }

}
