package com.company;

import data.PostgresDB;
import data.interfaces.IDB;
import repositories.ProductRepository;
import repositories.UserRepository;
import repositories.OrderRepository;
import repositories.interfaces.IProductRepository;
import repositories.interfaces.IUserRepository;
import repositories.interfaces.IOrderRepository;
import controllers.ProductController;
import controllers.interfaces.IProductController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Используем Singleton
        IDB db = PostgresDB.getInstance();

        // Создаём репозитории
        IProductRepository productRepo = new ProductRepository(db);
        IUserRepository userRepo = new UserRepository(db);
        IOrderRepository orderRepo = new OrderRepository(db);

        // Создаём контроллер
        IProductController productController = new ProductController(productRepo);

        // Создаём консоли
        UserConsole userConsole = new UserConsole(productController, (UserRepository) userRepo);
        AdminConsole adminConsole = new AdminConsole(productController, orderRepo); // Добавили orderRepo

        // Выбор консоли
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Product Management Application");
        System.out.println("1. Admin Console");
        System.out.println("2. User Console");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                adminConsole.start();
                break;
            case 2:
                userConsole.start();
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                break;
        }
    }
}
