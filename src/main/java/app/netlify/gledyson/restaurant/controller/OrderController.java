package app.netlify.gledyson.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@Controller
@CrossOrigin
public class OrderController {

    private Logger log = LoggerFactory.getLogger(OrderController.class);

    @MessageMapping("greeting")
    public String handle(String greeting) throws InterruptedException {
        log.info("GREETING ENDPOINT CALLED!!!");
        Thread.sleep(5000);
        return "" + LocalDateTime.now() + ": " + greeting;
    }

}
