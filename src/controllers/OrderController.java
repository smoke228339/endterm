package controllers;

import controllers.interfaces.IOrderController;
import entities.OrderItemDetails;
import repositories.interfaces.IOrderRepository;

public class OrderController implements IOrderController {
    private final IOrderRepository orderRepository;

    public OrderController(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderItemDetails getFullOrderDescription(int orderId) {
        return orderRepository.getFullOrderDescription(orderId);
    }
}
