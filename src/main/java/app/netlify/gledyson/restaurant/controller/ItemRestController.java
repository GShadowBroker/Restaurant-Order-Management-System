package app.netlify.gledyson.restaurant.controller;

import app.netlify.gledyson.restaurant.model.Item;
import app.netlify.gledyson.restaurant.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemRestController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    @CrossOrigin
    public List<Item> getAllItems() {
        return itemService.getAll();
    }

    @GetMapping("some")
    @CrossOrigin
    public List<Item> getSomeItems(
            @RequestParam(name = "limit", required = false, defaultValue = "5") int limit,
            @RequestParam(name = "offset", required = false, defaultValue = "0") int offset
    ) {
        return itemService.getSome(limit, offset);
    }

    @GetMapping("search")
    @CrossOrigin
    public List<Item> searchItems(
            @RequestParam(name = "term") String term,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(name = "offset", required = false, defaultValue = "0") int offset
    ) {
        return itemService.searchItems(term, limit, offset);
    }
}
