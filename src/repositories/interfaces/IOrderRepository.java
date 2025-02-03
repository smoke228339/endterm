package repositories.interfaces;

import entities.OrderItemDetails;

import java.util.List;

public interface IOrderRepository {
    OrderItemDetails getFullOrderDescription(int orderId);

    List<OrderItemDetails> getOrderDetails(int orderId);
}
