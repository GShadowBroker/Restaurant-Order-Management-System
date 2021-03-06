package app.netlify.gledyson.restaurant.controller;

import app.netlify.gledyson.restaurant.model.CustomerOrder;
import app.netlify.gledyson.restaurant.model.OrderForm;
import app.netlify.gledyson.restaurant.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderRestController {

    @Autowired
    CustomerOrderService customerOrderService;

    @GetMapping
    @CrossOrigin
    public List<CustomerOrder> getAll() {
        return customerOrderService.getCustomerOrders();
    }

    @PostMapping
    @CrossOrigin
    public CustomerOrder createNewOrder(@RequestBody OrderForm form) {
        return customerOrderService.createNewOrder(
                form.getCustomerId(),
                form.getItems(),
                form.getObservation()
        );
    }

    @PutMapping("/{orderId}")
    @CrossOrigin
    public void updateState(@PathVariable long orderId, @RequestParam String status) {
        customerOrderService.updateStatus(orderId, status);
    }

    @DeleteMapping("/{orderId}")
    @CrossOrigin
    public void deleteOrder(@PathVariable long orderId) {
        customerOrderService.deleteOrderById(orderId);
    }

}
