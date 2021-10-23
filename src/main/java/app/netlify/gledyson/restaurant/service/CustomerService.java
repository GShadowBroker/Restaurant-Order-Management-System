package app.netlify.gledyson.restaurant.service;

import app.netlify.gledyson.restaurant.model.Customer;
import app.netlify.gledyson.restaurant.model.CustomerOrder;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer getCustomerById(UUID customerId);
    List<CustomerOrder> getCustomerOrders(UUID customerId);
    List<Customer> getCustomers(int offset, int limit);
}
