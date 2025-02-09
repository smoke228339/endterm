package entities;

public class ProductBuilder {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private int year;

    public ProductBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public Product build() {
        return new Product(name, price, quantity, year);
    }
}