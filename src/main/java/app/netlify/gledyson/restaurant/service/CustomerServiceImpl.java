package app.netlify.gledyson.restaurant.service;

import app.netlify.gledyson.restaurant.exception.CustomerNotFoundException;
import app.netlify.gledyson.restaurant.model.Customer;
import app.netlify.gledyson.restaurant.model.CustomerOrder;
import app.netlify.gledyson.restaurant.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerRepository repository;

    private static final String CUSTOMER_NOT_FOUND = "Customer '%s' not found";

    @Override
    public Customer getCustomerById(UUID customerId) {
        log.info("Fetching user {}", customerId.toString());
        return repository.findById(customerId)
                .orElseThrow(() -> {
                    throw new CustomerNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerId));
                });
    }

    @Override
    public List<CustomerOrder> getCustomerOrders(UUID customerId) {
        Customer customer = getCustomerById(customerId);
        return customer.getCustomerOrders();
    }

    @Override
    public List<Customer> getCustomers(int offset, int limit) {
        return repository.getSome(PageRequest.of(offset, limit));
    }
}
