package app.netlify.gledyson.restaurant.service;

import app.netlify.gledyson.restaurant.model.CustomerOrder;
import app.netlify.gledyson.restaurant.model.Item;
import app.netlify.gledyson.restaurant.model.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface CustomerOrderService {
    CustomerOrder getCustomerOrderById(long id);

    List<CustomerOrder> getCustomerOrders();

    CustomerOrder createNewOrder(UUID customerId, List<Item> items, String observation);

    void updateStatus(long orderId, OrderStatus newStatus);

    void deleteOrderById(long orderId);
}
