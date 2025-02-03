package entities;

import java.util.Date;

public class OrderItemDetails {
    private int orderId;
    private Date orderDate;
    private int orderQuantity;
    private int productId;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private int productYear;

    public OrderItemDetails(int orderId, Date orderDate, int orderQuantity, int productId,
                            String productName, double productPrice, int productQuantity, int productYear) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productYear = productYear;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    @Override
    public String toString() {
        return String.format("Order ID: %d, Order Date: %s, Quantity: %d, Product ID: %d, Product: %s, Price: %.2f, Year: %d",
                orderId, orderDate, orderQuantity, productId, productName, productPrice, productYear);
    }
}

