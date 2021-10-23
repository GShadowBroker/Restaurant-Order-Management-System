package app.netlify.gledyson.restaurant.controller;

import app.netlify.gledyson.restaurant.model.Item;
import app.netlify.gledyson.restaurant.model.LimitOffsetForm;
import app.netlify.gledyson.restaurant.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("items/some")
    @CrossOrigin
    public List<Item> getSomeItems(
            @RequestParam(name = "limit", required = false, defaultValue = "5") int limit,
            @RequestParam(name = "offset", required = false, defaultValue = "0") int offset
    ) {
        return itemService.getSome(limit, offset);
    }
}
