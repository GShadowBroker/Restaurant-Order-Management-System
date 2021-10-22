package app.netlify.gledyson.restaurant.service;

import app.netlify.gledyson.restaurant.exception.ItemNotFoundException;
import app.netlify.gledyson.restaurant.model.Item;
import app.netlify.gledyson.restaurant.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    private static final String ITEM_NOT_FOUND = "Item '%s' not found";

    @Override
    public Item getItemById(long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> {
                    throw new ItemNotFoundException(String.format(ITEM_NOT_FOUND, id));
                });
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }
}
