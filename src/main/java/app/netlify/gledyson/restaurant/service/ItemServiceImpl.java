package app.netlify.gledyson.restaurant.service;

import app.netlify.gledyson.restaurant.exception.ItemNotFoundException;
import app.netlify.gledyson.restaurant.model.Item;
import app.netlify.gledyson.restaurant.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    private final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    private static final String ITEM_NOT_FOUND = "Item '%s' not found";

    @Override
    public Item getItemById(long id) {
        return itemRepository
                .findById(id)
                .orElseThrow(() -> {
                    throw new ItemNotFoundException(String.format(ITEM_NOT_FOUND, id));
                });
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getSome(int limit, int offset) {
        return itemRepository.getSome(PageRequest.of(offset, limit));
    }

    @Override
    public List<Item> searchItems(String searchTerm, int limit, int offset) {
        log.info("searchTerm is {}", searchTerm);
        return itemRepository.searchItems(searchTerm, PageRequest.of(offset, limit));
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

}
