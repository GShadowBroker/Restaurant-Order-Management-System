package app.netlify.gledyson.restaurant.controller;

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

    private Logger log = LoggerFactory.getLogger(OrderWebSocketController.class);

    @Autowired
    CustomerOrderService orderService;

    @MessageMapping("greeting")
    @SendTo("/topic/chat")
    public String handle(String greeting) throws InterruptedException {
        log.info("GREETING ENDPOINT CALLED!!!");
        Thread.sleep(1000);
        return "" + LocalDateTime.now() + ": " + greeting;
    }

    @MessageMapping("order")
    public void makeOrder(OrderForm orderForm) {
        log.info("Requesting new order: {}", orderForm);

        orderService.createNewOrder(
                orderForm.getCustomerId(),
                orderForm.getItems(),
                orderForm.getObservation()
        );
    }
}
