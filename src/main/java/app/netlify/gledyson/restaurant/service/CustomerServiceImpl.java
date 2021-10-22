package app.netlify.gledyson.restaurant.service;

import app.netlify.gledyson.restaurant.exception.CustomerNotFoundException;
import app.netlify.gledyson.restaurant.model.Customer;
import app.netlify.gledyson.restaurant.model.CustomerOrder;
import app.netlify.gledyson.restaurant.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    private static final String CUSTOMER_NOT_FOUND = "Customer '%s' not found";

    @Override
    public Customer getCustomerById(UUID customerId) {
        return repository.findById(customerId)
                .orElseThrow(() -> {
                    throw new CustomerNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerId));
                });
    }

    @Override
    public List<CustomerOrder> getCustomerOrders(UUID customerId) {
        Customer customer = getCustomerById(customerId);
        return customer.getOrders();
    }
}
