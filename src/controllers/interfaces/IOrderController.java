package controllers.interfaces;

import entities.OrderItemDetails;

public interface IOrderController {
    OrderItemDetails getFullOrderDescription(int orderId);
}
