package com.company;

import controllers.interfaces.IProductController;
import entities.Product;
import entities.User;
import repositories.UserRepository;
import java.util.Scanner;
import java.util.List;


public class UserConsole {
    private final IProductController controller;
    private final Scanner scanner;
    private final UserRepository userRepository;

    public UserConsole(IProductController controller, UserRepository userRepository) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
        this.userRepository = userRepository;
    }

    public void start() {
        while (true) {
            System.out.println("\nUser Console");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View all products");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            int option = this.scanner.nextInt();

            if (option == 0) {
                System.out.println("Goodbye!");
                break;
            }

            switch (option) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    viewProducts();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void register() {
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        System.out.println("Enter role (user):");
        String role = "user";
        boolean result = userRepository.registerUser(username, password, role);
        System.out.println(result ? "Registration successful!" : "Registration failed.");
    }

    private void login() {
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        User user = userRepository.loginUser(username, password);
        if (user != null) {
            System.out.println("Login successful! Welcome " + user.getUsername());
            viewProducts();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void viewProducts() {
        List<Product> products = controller.getAllProducts();
        products.forEach(System.out::println);
    }
}