package app.netlify.gledyson.restaurant.service;

import app.netlify.gledyson.restaurant.model.Item;

import java.util.List;

public interface ItemService {
    Item getItemById(long id);
    List<Item> getAll();
}
