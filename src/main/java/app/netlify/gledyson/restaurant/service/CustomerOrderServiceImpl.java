package app.netlify.gledyson.restaurant.service;

import app.netlify.gledyson.restaurant.exception.CustomerOrderNotFoundException;
import app.netlify.gledyson.restaurant.model.Customer;
import app.netlify.gledyson.restaurant.model.CustomerOrder;
import app.netlify.gledyson.restaurant.model.Item;
import app.netlify.gledyson.restaurant.model.OrderStatus;
import app.netlify.gledyson.restaurant.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    private static final String CUSTOMER_ORDER_NOT_FOUND = "Order '%s' not found";

    @Override
    public CustomerOrder getCustomerOrderById(long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> {
                    throw new CustomerOrderNotFoundException(
                            String.format(CUSTOMER_ORDER_NOT_FOUND, id)
                    );
                });
    }

    @Override
    public List<CustomerOrder> getCustomerOrders() {
        return orderRepository.findAll();
    }

    @Override
    public CustomerOrder createNewOrder(UUID customerId, List<Item> items, String observation) {
        Customer customer = customerService.getCustomerById(customerId);

        CustomerOrder order = new CustomerOrder(customer, items, observation);

        return orderRepository.save(order);
    }

    @Override
    public void updateStatus(long orderId, OrderStatus newStatus) {
        orderRepository.updateStatus(orderId, newStatus.name());
    }

    @Override
    public void deleteOrderById(long orderId) {
        orderRepository.deleteById(orderId);
    }
}
