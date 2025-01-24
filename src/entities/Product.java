package entities;

public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private int year;

    public Product() {
    }

    public Product(String name, int price, int quantity, int year) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setYear(year);
    }

    public Product(int id, String name, int price, int quantity, int year) {
        this(name, price, quantity, year);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%d, quantity=%d, year=%d}",
                id, name, price, quantity, year);
    }
}
