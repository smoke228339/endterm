package repositories;

import data.interfaces.IDB;
import repositories.interfaces.IOrderRepository;
import entities.OrderItemDetails;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private final IDB db;

    public OrderRepository(IDB db) {
        this.db = db;
    }

    @Override
    public List<OrderItemDetails> getOrderDetails(int orderId) {
        String query = "SELECT " +
                "o.id AS order_id, " +
                "o.order_date, " +
                "o.quantity AS order_quantity, " +
                "e.id AS product_id, " +
                "e.name AS product_name, " +
                "e.price AS product_price, " +
                "e.quantity AS product_quantity, " +
                "e.year AS product_year " +
                "FROM orders o " +
                "JOIN endterm e ON o.product_id = e.id " +
                "WHERE o.id = ?";

        List<OrderItemDetails> orderDetails = new ArrayList<>();
        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OrderItemDetails orderItem = new OrderItemDetails(
                        rs.getInt("order_id"),
                        rs.getDate("order_date"),
                        rs.getInt("order_quantity"),
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("product_price"),
                        rs.getInt("product_quantity"),
                        rs.getInt("product_year")
                );
                orderDetails.add(orderItem);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    @Override
    public OrderItemDetails getFullOrderDescription(int orderId) {
        return null;
    }
}
;