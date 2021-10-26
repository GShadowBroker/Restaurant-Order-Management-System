package app.netlify.gledyson.restaurant.controller;

import app.netlify.gledyson.restaurant.model.CustomerOrder;
import app.netlify.gledyson.restaurant.model.OrderForm;
import app.netlify.gledyson.restaurant.service.CustomerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@Controller
@CrossOrigin
public class OrderWebSocketController {

    private final Logger log = LoggerFactory.getLogger(OrderWebSocketController.class);

    @Autowired
    CustomerOrderService orderService;

    @MessageMapping("order/add")
    @SendTo("/topic/order")
    public CustomerOrder makeOrder(OrderForm orderForm) {
        log.info("Requesting new order: {}", orderForm);

        return orderService.createNewOrder(
                orderForm.getCustomerId(),
                orderForm.getItems(),
                orderForm.getObservation()
        );
    }

    @MessageMapping("order/notify")
    @SendTo("/topic/order")
    public String notifyOrderStatusChanged() {
        log.info("Notifying all subscribers about order status update");

        return "done";
    }
}
