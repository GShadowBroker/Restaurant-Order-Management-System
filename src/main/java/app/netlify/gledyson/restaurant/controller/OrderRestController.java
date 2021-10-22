package app.netlify.gledyson.restaurant.controller;

import app.netlify.gledyson.restaurant.model.Item;
import app.netlify.gledyson.restaurant.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderRestController {

    @Autowired
    ItemService itemService;

    @GetMapping("items")
    @CrossOrigin
    public List<Item> getAllItems() {
        return itemService.getAll();
    }
}
