package app.netlify.gledyson.restaurant.controller;

import app.netlify.gledyson.restaurant.model.Customer;
import app.netlify.gledyson.restaurant.model.CustomerOrder;
import app.netlify.gledyson.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @CrossOrigin
    public List<Customer> getCustomers(
            @RequestParam(name = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(name = "limit", required = false, defaultValue = "3") int limit
    ) {
        return customerService.getCustomers(offset, limit);
    }

    @GetMapping("/{customerId}/order")
    @CrossOrigin
    public List<CustomerOrder> getOrders(@PathVariable String customerId) {
        return customerService.getCustomerOrders(UUID.fromString(customerId));
    }
}
